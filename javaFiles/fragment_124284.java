public class Students {

    static ArrayList<Student> AllStudents= new ArrayList<Student>();

    public static void main(String[] args) throws Exception {
        String stdID;
        int tScore1;
        int tScore2;
        int tScore3;
        String sName;
        String fName;
        String lName;
        String wName;
        Student workobj;
        //****************************************External Output*****************************************************
        PrintWriter output;
        output=new PrintWriter(new File("StudentOut.txt"));
        //****************************************External Input******************************************************
        try{
            //opening the file for input
            FileInputStream istream = new FileInputStream("input.txt");
            Scanner input = new Scanner(istream);
                //creating an arraylist to store student objects
            while(input.hasNextLine()) {

                //first I will read the student id
                stdID=input.next();

                //next I will read the student name
                fName= input.next();
                lName=input.next();
                if (input.hasNextInt()){
                    wName="";
                }else{
                    wName=input.next();
                }
                sName=fName+" " +lName+" "+wName;

                //next read in the test scores
                tScore1=input.nextInt();
                tScore2=input.nextInt();
                tScore3=input.nextInt();

                //creating a student object
                Student StudentRecord= new Student(stdID,sName,tScore1,tScore2,tScore3);
                StudentRecord.listStudents();
                //now store this in allstudents
                addStudent(AllStudents, StudentRecord);
            }//end of while
            //Now I will list the records

            System.out.println("Getting Students from AllStudents Container");
            for(int i=0;i<=AllStudents.size()-1;i++){
                //retrieving the object
                workobj=AllStudents.get(i);
                workobj.listStudents();
            }//end of for

            System.out.println("Size prior to deleting="+AllStudents.size());
            deleteStudent(AllStudents, "99I9");
            System.out.println("Size after deleting="+AllStudents.size());

            System.out.println("This is the sorted values of Students from the AllStudents container");
            sortLarge(AllStudents);
            for(int i=0; i<=AllStudents.size()-1;i++){
                workobj=AllStudents.get(i);
                workobj.listStudents();
            }

        }//end of try

            catch (FileNotFoundException e){
                System.out.println("file not found");
                System.err.println("File not found");
                System.exit(11);
        }// end catch
                catch (InputMismatchException e){
                    System.out.println("Error in Reading File");
                    System.err.println("Error in Reading File");
                    System.exit(10);
                }
        finally {
            output.close();
            System.exit(2);
        }
    }//end of main

    static class Student {
        //This is the student class object. It calculates the test average, and finds the grade
        String studentID;
        String Name;
        int TestScore01;
        int TestScore02;
        int TestScore03;
        double tAvg;
        String tGrade;

        public Student(String stdID, String sName, int tScore1,int tScore2, int tScore3){
            studentID=stdID;
            Name=sName;
            TestScore01=tScore1;
            TestScore02=tScore2;
            TestScore03=tScore3;
            //finding avg test score
            tAvg = ((tScore1+ tScore2 + tScore3)/300.0)*100;
            //finding grade
            if(tAvg>=90){
                tGrade="A";
            }else if(tAvg>=80){
                tGrade="B";
            }else if(tAvg>=70){
                tGrade="C";
            }else if(tAvg>=60){
                tGrade="D";
            }else{
                tGrade="F";
            }
        }//end of students
        public void listStudents(){
            //this function lists all of the elements of the student
            System.out.println("\nNew Student\n Student ID: "+studentID);
            System.out.println(" Student Name: "+ Name);
            System.out.println(" Test 1 Score: " + TestScore01);
            System.out.println(" Test 2 Score: " +TestScore02);
            System.out.println(" Test 2 Score:" + TestScore03);
            System.out.println(" Average Test Score " +tAvg);
            System.out.println(" Grade: " + tGrade);
        }//end of listStudents()
        public int compareTo(Object o){
            //this functions compares the average test score of two students
            if (gettAvg()<((Student)o).gettAvg()) return 1;
            else
                if(gettAvg()>((Student)o).gettAvg())return-1;
                    else return 0;
        }//end of compareTo
        public double gettAvg(){
            return tAvg;
        }
    }//end of class students

    public static void addStudent(ArrayList<Student>AllStudents, Student workobj)
    {
        AllStudents.add(workobj);
    }

    public static void addStudent (String stdID, String sName, int tScore1,int tScore2, int tScore3){
        Student StudentRecord= new Student(stdID,sName,tScore1,tScore2,tScore3);
        AllStudents.add(StudentRecord);
    }

    public static void deleteStudent(ArrayList<Student>studentsArrayList,String stdID) {

        Iterator<Student> i = studentsArrayList.iterator();
        while (i.hasNext()) {
            Student student = i.next();
            if (student.studentID.equalsIgnoreCase(stdID)) 
                i.remove();
        }
    }


    public static void sortLarge(ArrayList<Student>mylist){
        Student xsave, ysave;
        int isw=1, xlast=mylist.size();
            while (isw==1){isw=0;
                for (int i=0;i<=xlast-2;i++){
                    if (((mylist.get(i)).compareTo((mylist.get(i+1)))==1)){
                        xsave=mylist.get(i);
                        ysave=mylist.get(i+1);
                        mylist.remove(i);
                        mylist.add(i,ysave);
                        mylist.remove(i+1);
                        mylist.add(i+1,xsave);
                        isw=1;
                    }
                }//end of for loop
            }//end of while
        return;
    }//end of sortLarge
}//end of program