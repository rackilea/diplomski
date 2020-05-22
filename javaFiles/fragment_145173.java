$ ./jshell
|  Welcome to JShell -- Version 1.9.0-internal
|  Type /help for help

-> int specialAdd(int a, int b) {
>>     if (a < 100) {
>>         return 100 * a + b;
>>     } else {
>>         return a + b;
>>     }
>> }
|  Added method specialAdd(int,int)

-> specialAdd(10, 5);
|  Expression value is: 1005
|    assigned to temporary variable $2 of type int