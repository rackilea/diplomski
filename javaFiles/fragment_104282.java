class Student{
    private static int studCreated = 0;

    public Student(){
        studCreated ++;   //Counts automatically
    }
    //Other constructors not shown here

    public static int getStudCreated(){
        return studCreated;
    }
}