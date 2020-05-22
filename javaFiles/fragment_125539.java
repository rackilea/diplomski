void xor(uint16_t *data, uint16_t *data2, size_t count, uint16_t *out) {
    uint8_t i;
    for(i = 0; i < count; i++){
        out[i] = data[i] ^ data2[i];
    }
}

+ (NSMutableData *)incrementCtrWithIv:(NSData *)iv increment:(uint16_t)increment {
    NSMutableData *ctrBytes = [[NSMutableData alloc] initWithCapacity:kCCBlockSizeAES128];
    NSMutableArray *arrayOfBytes = [[NSMutableArray alloc] initWithCapacity:8];

    bool carry = true;
    // increment the counter (which is the last 8 bytes of the IV) by 1
    for (int k = 7; k >= 0 ; k--) {
        uint16_t ctr = 0;
        [iv getBytes:&ctr range:NSMakeRange((NSUInteger) (8+k), 1)];
        if (carry){
            if ((ctr + increment) >  255){
                ctr = (uint16_t) (ctr + increment) % 256;
                increment -= ctr;
            }  else {
                ctr += increment;
                carry = false;
            }
        }
        [arrayOfBytes addObject:[NSData dataWithBytes:&ctr length:1]];
    }
    // append the bytes in correct order (reverse of above)
    for (int k=7; k>=0;k--) {
        [ctrBytes appendData:[arrayOfBytes objectAtIndex:(NSUInteger) k]];
    }
    return ctrBytes;
}

+ (NSData *)symmetricCipher:(NSData *)data key:(NSData *)symmetricKey context:(CCOperation)encryptOrDecrypt {
    // Cipher Text container.
    NSMutableData *cipherOrPlainText = [[NSMutableData alloc] initWithCapacity:([data length] + kCCBlockSizeAES128)];

    // Initialization vector;
    NSData *iv = [[data subdataWithRange:NSMakeRange(0, kCCBlockSizeAES128)] copy];

    NSUInteger dataLength = data.length;

    uint8_t start = 0;

    if (encryptOrDecrypt == kCCDecrypt) {
        // iv is first block
        start += kCCBlockSizeAES128;

        dataLength-=kCCBlockSizeAES128;

    } else {
        iv = [self generateIv];
    }

    NSData *incrementalIv = [iv copy];

    size_t blocks = ((dataLength + kCCBlockSizeAES128) / kCCBlockSizeAES128);

    // should fit for less than 2^16 blocks
    for (uint16_t j = 0; j<blocks; j++) {

        size_t realLengthRemaining = dataLength - j*kCCBlockSizeAES128;
        size_t actualLength = (size_t) (realLengthRemaining >  kCCBlockSizeAES128 ? kCCBlockSizeAES128 : realLengthRemaining);

        if (realLengthRemaining > 0){

            // increment the counter (which is the last 8 bytes of the IV) by 1
            if (0 != j) {
                NSData *ctrBytes = [Crypto incrementCtrWithIv:incrementalIv increment:1];
                // start with nonce
                NSMutableData *ctrIv = [[iv subdataWithRange:NSMakeRange(0, 8)] mutableCopy];
                // and append the counter
                [ctrIv appendData:ctrBytes];

                // next Iv is equal to this calculated iv
                incrementalIv = ctrIv;
            }

            // symmetric cipher reference
            CCCryptorRef cryptor = NULL;
            // Pointer to output buffer.
            uint8_t *bufferPtr = NULL;
            // Remaining bytes to be performed on.
            size_t remainingBytes = 0;
            // Number of bytes moved to buffer.
            size_t movedBytes = 0;
            // Total size of the buffer.
            size_t bufferPtrSize = 0;
            // Placeholder for total written.
            size_t totalBytesWritten = 0;
            // A friendly helper pointer.


            LOGGING_FACILITY(data != nil, @"PlainText object cannot be nil." );
            LOGGING_FACILITY(symmetricKey != nil, @"Symmetric key object cannot be nil." );
            LOGGING_FACILITY([symmetricKey length] == kCCKeySizeAES256, @"Disjoint choices for key size." );

            // Create and Initialize the cipher reference.
            CCCryptorStatus status = CCCryptorCreateWithMode(kCCEncrypt, kCCModeECB, kCCAlgorithmAES128, ccNoPadding,
                    nil, [symmetricKey bytes], kCCKeySizeAES256, NULL, 0, 0, 0, &cryptor);

            LOGGING_FACILITY1( status == kCCSuccess, @"Problem creating the context, status == %d.", status );

            // Calculate byte block alignment for all calls through to and including final.
            bufferPtrSize = CCCryptorGetOutputLength(cryptor, kCCBlockSizeAES128, true);

            // Allocate buffer.
            bufferPtr = malloc(bufferPtrSize * sizeof(uint8_t));

            // Zero out buffer.
            memset((void *) bufferPtr, 0x0, bufferPtrSize);

            // Initialize some necessary book keeping.
            uint8_t *ptr = bufferPtr;

            // Set up initial size.
            remainingBytes = bufferPtrSize;

            // Actually perform the encryption or decryption.
            status = CCCryptorUpdate(cryptor,
                    [incrementalIv bytes],
                    kCCBlockSizeAES128,
                    ptr,
                    remainingBytes,
                    &movedBytes
            );

            LOGGING_FACILITY1( status == kCCSuccess, @"Problem with CCCryptorUpdate, status == %d.", status );

            // Handle book keeping.
            ptr += movedBytes;
            remainingBytes -= movedBytes;
            totalBytesWritten += movedBytes;

            // Finalize everything to the output buffer.
            status = CCCryptorFinal(cryptor,
                    ptr,
                    remainingBytes,
                    &movedBytes
            );

            totalBytesWritten += movedBytes;

            if (cryptor) {
                (void) CCCryptorRelease(cryptor);
                cryptor = NULL;
            }

            NSData *out = [NSData dataWithBytes:bufferPtr length:(NSUInteger) totalBytesWritten];
            if (bufferPtr) free(bufferPtr);


            NSData *input = [data subdataWithRange:NSMakeRange(start + j*kCCBlockSizeAES128, actualLength)];

            uint16_t xord[kCCBlockSizeAES128] = {0};
            // xor the counter with the message block
            xor([input bytes],[out bytes], actualLength, xord);

            LOGGING_FACILITY1( status == kCCSuccess, @"Problem with encipherment status == %d", status );

            NSData *blockData = [NSData dataWithBytes:xord length:(NSUInteger) actualLength];

            NSString *decryptedText = [[NSString alloc] initWithData:blockData encoding:NSASCIIStringEncoding];
//            NSLog(@"decrypted block %d: %@", j ,decryptedText);

            [cipherOrPlainText appendData:blockData];

            [self wipeData:blockData];
        }
    }

    if (encryptOrDecrypt == kCCEncrypt) {
        NSMutableData *cipherText = [[NSMutableData alloc] initWithData:iv];
        [cipherText appendData:cipherOrPlainText];
        cipherOrPlainText = cipherText;
    }

    [self wipeData:iv];
    [self wipeData:incrementalIv];

    return cipherOrPlainText;
}

+ (void)wipeData:(NSData *)data {
    memset([data bytes], 0, [data length]);
}