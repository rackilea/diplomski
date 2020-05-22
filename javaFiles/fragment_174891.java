#import <CommonCrypto/CommonDigest.h>

- (NSString *) encodeString:(NSString *) s {
   const char *cStr = [s UTF8String];
   unsigned char result[CC_MD5_DIGEST_LENGTH];
   CC_MD5(cStr, strlen(cStr), result);
   NSMutableString *result = [NSMutableString stringWithCapacity:CC_MD5_DIGEST_LENGTH * 2];
   for(int i = 0; i < CC_MD5_DIGEST_LENGTH; ++i) {
      [result appendFormat:@"%02x", result[i]];
   }       
   return [NSString stringWithString:result];
}