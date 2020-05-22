for (k = 1; k < (n + 1); k++) {
    for (i = 0; i < n - k; i++) {
        System.out.print(" ");
    }
    for (j = 0; j < k; j++) {
        if(j == 0)
            if(k == n+1)
                System.out.print("*");
            else
                System.out.print(" *");
        else{
            System.out.print("$*");
        }
    }
    System.out.println("");
}

for (k = 1; k < n; k++) {
    for (i = 0; i < k; i++) {
        System.out.print(" ");
    }
    for (j = 0; j < n - k; j++) {
        if(j == 0)
            if(k == n+1)
                System.out.print("*");
            else
                System.out.print(" *");
        else{
            System.out.print("$*");
        }
    }
    System.out.println("");
}