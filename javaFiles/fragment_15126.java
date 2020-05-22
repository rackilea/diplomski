public static void printCat() {
    Mammal result;

    do 
    {
        int index = shuffleArray.nextInt(mammals.size());
        result = mammals.get(index);
    } while (!(result instanceof Cat));

    System.out.println(result);
}