String firstName, lastName, age, grade;

while(fileScanner.hasNextLine()){
    firstName = fileScanner.nextLine();
    lastName = fileScanner.nextLine();
    age = fileScanner.nextLine();
    grade = fileScanner.nextLine();
    i++;
    System.out.println(i);
}


studentArray[i] = new Student(firstName, lastName, age, grade);