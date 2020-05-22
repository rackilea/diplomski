try{
    System.out.print("Enter an integer: ");
    int number = input.nextInt();  
    }
    catch (InputMismatchException ex) {
        System.out.println("Incorrect input: an integer is required)");
        //It's also possible to throw your custom Exception here, like "throw new CustomException();"
    }