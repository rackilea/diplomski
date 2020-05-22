OUTER:
while(x > 0) {
    for(int i = 5; i > 0; i++) {
        x = x-2;
        if(x == 0)
            break OUTER;
    }
}