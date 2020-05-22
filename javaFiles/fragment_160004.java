#import <Foundation/Foundation.h>

/*

See:
http://stackoverflow.com/questions/3505942/i-cant-see-the-output-of-nstask-objective-c-java

compile with:
gcc -Wall -O3 -x objective-c -fobjc-exceptions -framework Foundation -o test test.c

./test

# create test.file
n=50
jot -b 'line' $n | nl -w 10 > test.file
echo "Jarvis>" | nl -w 10 -v $((n+1)) >> test.file
jot -b 'line' 19 | nl -w 10 -v $((n+2)) >> test.file

ls -lh test.file
tail -n 100 test.file

# create server.sh
echo '
cat test.file
' > server.sh

sh server.sh

./test

*/


int main(int argc, const char *argv[])
{

    NSAutoreleasePool *pool =  [[NSAutoreleasePool alloc] init];
    NSString *shfile = @"server.sh";

    NSString *shstring = [NSString stringWithFormat:
             @"%@ %@ %@", 
             @"source", 
             shfile, 
             @"| /usr/bin/sed '/Jarvis>/q'"
    ];

    NSTask *sh = [NSTask new];
    NSPipe *pipe = [NSPipe new];
    [sh setLaunchPath:@"/bin/sh"];
    [sh setArguments:[NSArray arrayWithObjects: @"-c", shstring, nil ]];
    [sh setCurrentDirectoryPath:@"."];
    //[sh setStandardInput:[NSFileHandle fileHandleWithNullDevice]];
    [sh setStandardError:[NSFileHandle fileHandleWithNullDevice]];
    [sh setStandardOutput:pipe];
    [sh launch];

    NSData *data = [[[sh standardOutput] fileHandleForReading] readDataToEndOfFile];
    NSString *string = [[[NSString alloc] initWithData:data encoding: NSUTF8StringEncoding] autorelease];

    NSLog(@"\n\n%@\n", string);

    [pool release];

    return 0;

}