Code:
 0: new #2; //class Token
 3: dup
 4: invokespecial   #3; //Method Token."<init>":()V
 7: invokevirtual   #4; //Method Token.dynamicType:()V
 10:    new #5; //class TestToken
 13:    dup
 14:    invokespecial   #6; //Method TestToken."<init>":()V
 17:    invokevirtual   #7; //Method TestToken.dynamicType:()V
 20:    invokestatic    #8; //Method Token.type:()V
 23:    invokestatic    #9; //Method TestToken.type:()V
 26:    return