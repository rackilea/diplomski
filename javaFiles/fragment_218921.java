public static Student getStudentInfo()
{
    Student tempStu = new Student();
    float ID_number;
    int Credit_hours;
    int points;
    Scanner input = new Scanner(System.in);
    System.out.print("Enter Student ID Number >> ");
    ID_number = input.nextFloat();
    tempStu.setID_number(ID_number);

return tempStu;
}