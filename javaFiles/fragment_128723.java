NSData* fullEncrypted       = [[NSData alloc] initWithBase64EncodedString: @"R5UBpP30YjX9Ae2HoPb2Rrfi5rQJY2d0ac1+zaIX5A4="  options: 0];
NSData *ivData = [fullEncrypted subdataWithRange:NSMakeRange(0, kCCBlockSizeAES128)];
NSData *encryptedData = [fullEncrypted subdataWithRange:NSMakeRange(kCCBlockSizeAES128, fullEncrypted.length-kCCBlockSizeAES128)];
NSLog(@"ivData:          %@", ivData);
NSLog(@"encryptedData:   %@", encryptedData);

NSData *keyData = [@"2EE1F10212ADD4BE" dataUsingEncoding:NSUTF8StringEncoding];
NSLog(@"keyData:         %@", keyData);

NSMutableData *unencryptedData = [NSMutableData dataWithLength:encryptedData.length];
size_t numBytesDecrypted = 0;
CCCryptorStatus cryptStatus = CCCrypt(kCCDecrypt,
                                      kCCAlgorithmAES,
                                      kCCOptionPKCS7Padding,
                                      keyData.bytes, keyData.length,
                                      ivData.bytes,
                                      encryptedData.bytes, encryptedData.length,
                                      unencryptedData.mutableBytes, unencryptedData.length,
                                      &numBytesDecrypted);
if (cryptStatus == kCCSuccess) {
    NSLog(@"Success");

    unencryptedData.length = numBytesDecrypted;
    NSLog(@"unencryptedData: %@", unencryptedData);

    NSString *decryptedString = [[NSString alloc] initWithData:unencryptedData encoding:NSUTF8StringEncoding];
    NSLog(@"decryptedString: %@", decryptedString);
}