class A {
    public static void main(String[] args) {
        if (1 == 1) // true
            if (2 == 2) // true
                if (2 != 2) // false
                    System.out.println("2 != 2");
                else
                    System.out.println("2 != 2"); // is actually 2 == 2, gets executed
            else
                System.out.println("1 != 1"); // is actually 2 != 2
    }
}