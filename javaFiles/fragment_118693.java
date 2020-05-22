Scanner input = new Scanner(System.in);
    while(input.hasNextLine()){
       //all variables are declared as local in the loop

        char [] name = new char[10];
        //read the name
        String firstName = input.next();

        //create the char array
        for(int j = 0; j < firstName.length(); j++){
            name [j] = firstName.charAt(j);
        }

       //print the char array(each char in new line)
        for(int i = 0; i < name.length; i++){
                System.out.println(name);                
        }

       //read and print ssn
        long ssn = input.nextLong();
        System.out.println(ssn); 


       //read and print grades
        double[] grades = new double[4];
        grades[0]= input.nextDouble();
        System.out.println(grades[0]); 
        grades[1]= input.nextDouble();
        System.out.println(grades[1]); 
        grades[2]= input.nextDouble();
        System.out.println(grades[2]); 
        grades[3]= input.nextDouble();
        System.out.println(grades[3]); 

        //ignore the new line char
        input.nextLine();
}

    //close your input stream
    input.close();