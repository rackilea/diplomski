// Provide Objective-C interfaces for the Java classes
// Not only good practice, it provides Code Sense
@interface java_util_Vector : NSObject
{}
- (void)add:(id)anObject;
- (id)get:(int)index;
@end

@interface HelloBridge : NSObject
{}
- (void)setString:(NSString *)string;
- (NSString *)getString;
- (void)printString;
@end