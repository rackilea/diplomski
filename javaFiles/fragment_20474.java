+ (NSString *) GetMonth: (NSString *) month{
    NSString* january = @"01;06:40;08:37;12:15;13:35;15:51;17:41&02;06:40;08:37;12:15;13:36;15:52;17:42&03;06:40;08:36;12:16;13:37;15:53;17:43&04;06:40;08:36;12:16;13:38;15:54;17:44&";
    NSString* february = @"01;06:13;08:01;12:24;14:19;16:46;18:27&02;06:12;07:59;12:25;14:21;16:48;18:29&03;06:10;07:57;12:25;14:22;16:50;18:31&04;06:09;07:55;12:25;14:24;16:52;18:33&";
    if ([[month lowercaseString] isEqualToString:@"january"]) return january;
    else if ([month lowercaseString] isEqualToString:@"february"]) return february;
    else return Nil;
}