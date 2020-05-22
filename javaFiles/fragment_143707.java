if(command.equals("character")){
    System.out.println("How many characters would you like generated?");
    int numcharacter = input.nextInt();

    RandomDataGenerator.random(numcharacter);//Call the methods
}
else if (command.equals("integer")){
    System.out.println("What is the upper limit and lower limit of the integers you want to generate?");  

    int maxn1 = input.nextInt();
    int minn2 = input.nextInt();

    System.out.println("How many integers do you want to generate?");

    int numinteger = input.nextInt();
    RandomDataGenerator.random(minn2,maxn1,numinteger); //Call the method

}
else if (command.equals("double")){
    System.out.println("What is the upper limit and lower limit of the doubles you want to generate?");

    double maxn3 = input.nextDouble();
    double minn4 = input.nextDouble();

    System.out.println("How many doubles do you want to generate?");

    int numdouble = input.nextInt();
    RandomDataGenerator.random(maxn3,minn4,numdouble); //Call the method
}