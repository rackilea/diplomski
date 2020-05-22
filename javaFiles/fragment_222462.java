Thread A                |  Thread B
1    boolean x = foo();      |
2    boolean y = stop || x;  |  
3                            |  stop = true;
4    stop = y                |
5    if(stop) { ... }