static const int iterations = 50000;
+ (NSString *) digestPassword:(NSString *)inputPassword {
    NSMutableData *dataOut = [NSMutableData dataWithLength:CC_SHA1_DIGEST_LENGTH];

#if 1 // UTF16
NSData *data = [inputPassword dataUsingEncoding:NSUTF16StringEncoding];
data = [data subdataWithRange:NSMakeRange(2, data.length-2)];
#else // UTF8
    NSData *data = [inputPassword dataUsingEncoding:NSUTF8StringEncoding];
#endif

    for (int iteration = 0; iteration < iterations; iteration++) {
        if (CC_SHA1([data bytes], [data length], dataOut.mutableBytes)) {
            data = dataOut;
        }
        else {
            NSLog(@"treta %i", iteration);
        }
    }

    unsigned char *digest = (unsigned char *)data.bytes;
    NSMutableString *result = [NSMutableString new];
    for (int index = 0 ; index < CC_SHA1_DIGEST_LENGTH ; index++) {
        [result appendFormat: @"%02x", digest[index]];
    }
    return result;
}