NSPipe *pipe = [NSPipe pipe];
[javaTask setStandardOutput:pipe];
[javaTask setStandardError:pipe];
NSFileHandle *fileHandleForReading = [pipe fileHandleForReading];

[javaTask launch];

NSData *result = [fileHandleForReading readDataToEndOfFile];

NSString *output = [[NSString alloc] initWithData:result encoding:NSUTF8StringEncoding];