for(int i = 1; i <= 10; i++) {
    System.out.println(table + "x" + i + "= ?");
    r = sc.nextInt();
    if(r == table * i) {
        System.out.println("Correct");
        p += 1;
    } else {
        System.out.println("Error");
        e += 1;
    }
}