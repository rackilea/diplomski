n : printf("hello");
    n-1 : printf("hello");
          n-2 : printf("hello");
                ....
                    2 : printf("hello");
                        1 : printf("hello");
                            0 : printf("world");  << Difference is here
                        1 : printf("world");
                    2 : printf("world");    
                ....                            
          n-2 : printf("world");
    n-1 : printf("world");
n : printf("world");