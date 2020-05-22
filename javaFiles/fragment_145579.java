/* Building.h */
@interface Building : NSObject
- (void)Update;
- (void)specialAction;
@end

/* Building.m */
@implementation Building

- (void)Update
{
    [self specialAction];
}

- (void)specialAction
{
    assert(0 && "override required"); // << see note
}

@end

/* House.h */
@interface House : Building
@end

/* House.m */
@implementation House

- (void)specialAction
{
    NSLog(@"Special Action Done");
}

@end

void ProgramMain()
{
    House * h = [House new];
    [h Update];
    [h release];
}