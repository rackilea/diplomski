// Create list of All Records
    public ArrayList<Students> getStudents(String fileName) throws Exception
    {
        System.out.println("2: Please Wait ....  ");
        String stdID;
        int tScore1;
        int tScore2;
        int tScore3;
        String sName;
        //reading from "input.txt"
        File data=new File(fileName);
        FileReader reader=new FileReader(data.getAbsoluteFile());
        BufferedReader breader= new BufferedReader(reader);

        String eachrow;
        ArrayList<Students> AllStudents= new ArrayList<Students>();
        while((eachrow = breader.readLine()) != null)
        {
            String []r = eachrow.split("\t")
                stdID = r[0];
                sName = r[1];
                tScore1 = r[2];
                tScore2 = r[3];
                tScore3 = r[4];
                //creating a student object
                Students StudentRecord= new Students(stdID,sName,tScore1,tScore2,tScore3);
                StudentRecord.listStudents();
                //now store this in allstudents
                AllStudents.add(StudentRecord);
        }

        System.out.println("Student Records are Created Successfully.");
        System.out.println("-----------------------------------------------------------------");
        return AllStudents;
    }