@protocol MyProtocol <NSObject>
-(void)test;
@end


@interface MyClass : NSObject <MyProtocol>

@end

@implementation MyClass
-(void) test
{
    ....
}
@end