public void baz();
Code:
   0: aload_0           // Push 'this' as the first parameter onto the stack
   1: iconst_1          // Push 1 as the second parameter onto the stack
   2: invokevirtual #2  // Call 'foo'
   5: iconst_2          // Push 2 as the first parameter onto the stack
   6: invokestatic  #3  // Call 'bar'
   9: return