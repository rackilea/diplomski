public void results(int num) {
    for (int i = 1; i < num; i++) {
        System.out.print(space(num - i));
        System.out.println(method1(i));
    }
    for (int i = 0; i < num; i++) {
        System.out.println(method2(num - i));
        if(i+1 < num) // make sure we have another star
            System.out.print(space(i));
    }
}