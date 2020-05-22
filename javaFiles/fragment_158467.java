static NSString* const myString = @"whatever";

// In some method

// Class methods are roughly equivalent to static methods in Java
NSData* byteArray = [[self class] toBytes: myString];

// Method definition
// The result is encapsulated in a NSData to take advantage of ARC for memory management
+ (NSData*) toBytes: (NSString*) aString
{
    NSUInteger size = [aString length];
    NSMutableData bytes = [NSMutableData dataWithLength: size / 2];
    // Get a pointer to the actual array of bytes
    uint8_t* bytePtr = [bytes mutableBytes];
    NSUInteger i = 0;
    // NB your code had a bug in that an exception is thrown if size is odd
    for (NSUInteger j = 0 ; j < size / 2 ; ++j)
    {
        bytePtr[j] = (([aString characterAtIndex: i] & 0xf) << 4)
                   | ([aString characterAtIndex: i + 1] & 0xf);
       i += 2;
    }
    // NSMutableData is a subclass of NSData, so return it directly.
    return bytes;
}