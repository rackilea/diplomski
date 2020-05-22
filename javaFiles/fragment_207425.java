- (NSString *)hexadecimalDescription 
{
    NSMutableString *string = [NSMutableString stringWithCapacity:[self length] * 2];
    const uint8_t *bytes = [self bytes];

    for (int i = 0; i < [self length]; i++)
        [string appendFormat:@"%02x", (uint32_t)bytes[i]];

    return [[string copy] autorelease];
}