outer:
for (int i = 2; i<=100 ; i++) {
    for (int j = 2 ; j < i-1 ; j++ ) {
        if (i%j == 0) {
            continue outer;
        }
    }
    System.out.println(i);      
}