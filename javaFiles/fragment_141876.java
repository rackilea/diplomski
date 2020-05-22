@interface NSData(NSDataAdditions)

- (char)byteAtIndex:(NSUInteger)index;

@end

@implementation NSData(NSDataAdditions)

- (char)byteAtIndex:(NSUInteger)index {
    char c;
    [self getBytes: &c range: NSMakeRange( index, 1 )];
    return c;
}

@end