public static void main(String... args){
    System.out.println(3%-2);
    System.out.println(4%-2);

    Test t1 = new Test();
    try {
        t1.mtd1(101);
        t1.mtd2(101);
    }
    catch (Exception e) {
        // do something
    }
}