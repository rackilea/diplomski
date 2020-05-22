public static void Display(animal x[][], animaltype y[]) {
    System.out.println("Your animals are..");
    for (int m = 0; m < x.length; m++) {
        System.out.printf("Following are the name and the breed of %s ",
                y[m].getAnimalType());
        System.out.println();
        for (int n = 0; n < x[m].length; n++) {
            //you only filled elements in x[m][0]
            //x[m][n] when n > 0 is null
            //so you will get NullPointerException
            System.out.printf(" %s", x[m][n].aname);
            System.out.printf(" %s", x[m][n].abreed);
            System.out.println();

        }
    }
}