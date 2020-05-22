public static void writePatientReports(int[] id, String[] patient, 
      String[] doctor, String[] surgery, double[] cost) {

     BufferedWriter Student_file = new BufferedWriter(new FileWriter("patient.txt"));
     for (i=0; i<=count; ++i)
    {
        //put "," between each data item in the file
        Student_file.write(id[i] + "," + patient[i] + "," + doctor[i]+ "," + surgery[i] + ","+ cost[i]+ ",");
        //write a new line in the file
        Student_file.write("\n");
    }//for loop
    Student_file.close();
  }