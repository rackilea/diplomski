for(int x = 0; x < count; x++){
     if(numID == stud[x].getNumID()) {
        System.out.println("The Student ID: " +numID+ " already exist.\nEnter New Student ID: ");
        numID = sc.nextInt();
        sc.nextLine();
        x = -1;
    }
}