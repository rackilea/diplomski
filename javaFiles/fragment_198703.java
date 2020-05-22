#import <Foundation/Foundation.h>
#import "JavaInterfaces.h"

int main (int argc, const char * argv[]) {
   NSAutoreleasePool * pool = [[NSAutoreleasePool alloc] init];

   // Load the Java VM
   id vm = NSJavaSetupVirtualMachine();

   // Start the Java class loader
   NSJavaClassesFromPath(nil, nil, YES, &vm);

   // Load a new instance of the java.util.Vector Java class into an Objective-C pointer
   java_util_Vector * vector = NSJavaObjectNamedInPath(@"java.util.Vector", nil);
   [vector add:@"one item!"];
   NSLog(@"item 1=%@",[vector get:0]);
   [vector release];

   // Load a new instance of our custom HelloBridge Java class into an Objective-C pointer
   HelloBridge * hello = NSJavaObjectNamedInPath(@"HelloBridge", nil);
   NSLog(@"item 1=%@",[hello getString]);
   [hello setString:@"Test"];
   NSLog(@"item 1=%@",[hello getString]);
   [hello printString];
   [hello release];

   [pool release];
   return 0;
}