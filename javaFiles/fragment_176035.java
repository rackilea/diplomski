try {
    myArr.add(scan2.nextDouble());
    count += 1;
} catch (InputMismatchException e) {
    System.out.println("Very funny! Now follow the instructions, will you?");
}