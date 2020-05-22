int state = 0;
WHILE: while(true) {
    switch (state) {
       case 0:
            // 1st some code here
            state = 1;
            break;
       case 1:
            state = check();
            break;
       case 2:
            return;
       case 3:
            break WHILE;
       case 4:
            // 2nd some code
            state = 1;
            break;
        ...
    }
 }