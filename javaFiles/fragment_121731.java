@class MyActionListener : NSObject<NSActionListener>

-(void) actionPerformed:(NSEvent*)event;

@end

myComponent.delegate = [[[MyActionListener alloc] init] autorelease];