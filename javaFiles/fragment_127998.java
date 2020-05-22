- (NSData *) AESECB : (NSData *) data withKey :(NSData *) key : (CCOperation) operation{

CCCryptorStatus ccStatus = kCCSuccess;
NSUInteger dataLength = data.length;
size_t bufferSize = dataLength + kCCBlockSizeAES128;
void *buffer = malloc( bufferSize );

size_t numBytes = 0;

ccStatus = CCCrypt(operation,  // will pass kCCDecrypt or kCCEncrypt
                   kCCAlgorithmAES,
                   kCCOptionECBMode | kCCOptionPKCS7Padding,
                   [key bytes],
                   [key length],
                   nil,
                   [data bytes],
                   [data length],
                   buffer,
                   bufferSize,
                   &numBytes);

if( ccStatus == kCCSuccess )
{
    return [NSData dataWithBytes:buffer length:numBytes];
}

free(buffer);
return nil;
}

- (NSData *) AESCBC : (NSData *) data withKey: (NSData *) key : (CCOperation) operation{
CCCryptorStatus ccStatus = kCCSuccess;
NSUInteger dataLength = data.length;
size_t bufferSize = dataLength + kCCBlockSizeAES128;
void *buffer = malloc( bufferSize );

size_t numBytes = 0;

ccStatus = CCCrypt(operation,  // will pass kCCDecrypt or kCCEncrypt
                   kCCAlgorithmAES,
                   kCCOptionPKCS7Padding,
                   [key bytes],
                   [key length],
                   self.IV.bytes,
                   [data bytes],
                   [data length],
                   buffer,
                   bufferSize,
                   &numBytes);

if( ccStatus == kCCSuccess )
{
    return [NSData dataWithBytes:buffer length:numBytes];
}

free(buffer);
return nil;
}