// get user directory
    NSArray *allPaths       = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *documentsDIR  = [allPaths objectAtIndex:0];
    NSString *pathForLog    = [documentsDIR stringByAppendingPathComponent:@"logFile.txt"];
    NSString *pathForError  = [documentsDIR stringByAppendingPathComponent:@"errorFile.txt"];

 // redirect the stream
   freopen([pathForError cStringUsingEncoding:NSASCIIStringEncoding],"w", stderr); // NSLog
   freopen([pathForLog cStringUsingEncoding:NSASCIIStringEncoding], "w", stdout); // printf

 // your log stuff
   printf("i am a robot\n");
   NSLog(@"And i do bip bipbip biiiip");

 // when you are done, close the stream
    fclose (stdout);
    fclose (stderr);

 // and retrieve your data, as NSString object (or whatever you want)
    NSString* dataLog = [NSString stringWithContentsOfFile: pathForLog
                                                  encoding: NSASCIIStringEncoding
                                                     error: nil];

    NSString* errorLog = [NSString stringWithContentsOfFile: pathForError
                                                   encoding: NSASCIIStringEncoding
                                                      error: nil];