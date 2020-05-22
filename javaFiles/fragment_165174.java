int iters = 0;
for (int i = 0; i < 7; i++) {
    for (int j = 0; j < 7; j++) {
        for(int k = 0; k < 7; k++) {
            if (i > 0 && i == j) // Added 1 line
            iters++;
        }
    } 
}
System.out.println(iters);