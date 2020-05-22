- (void)readFromStream{
int BUFFER_LEN = 512;

uint8_t *buffer;
NSUInteger length;
BOOL freeBuffer = NO;
// The stream has data. Try to get its internal buffer instead of creating one
if(![inputStream getBuffer:&buffer length:&length]) {
    // The stream couldn't provide its internal buffer. We have to make one ourselves
    buffer = malloc(BUFFER_LEN * sizeof(uint8_t));
    freeBuffer = YES;
    NSInteger result = [inputStream read:buffer maxLength:BUFFER_LEN];
    length = result;
}

if (buffer != NULL) {
    NSString *s = [[NSString alloc] initWithBytes:buffer length:length encoding:NSASCIIStringEncoding];
    if (s.length>1) {
        CLS_LOG(@"Read: %@",s);
        [self handleRecievedMessage:s];
    }
}

// length bytes of data in buffer
if(freeBuffer) free(buffer);