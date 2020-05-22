@interface MYClass : NSObject {
@private
   int var;                            // 1
}

@property(nonatomic, assign) int var;  // 2

-(void)someMethodWithVar:(int)var;     // 3

@end