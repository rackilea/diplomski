try {
    num[i] = input.nextInt();
} catch (Exception e) {
    System.out
            .println("Invalid number..assigning default value 20");
    num[i] = 20;
    input.next();
}