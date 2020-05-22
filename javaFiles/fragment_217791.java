public class SpinnerData{
    private String courseName;
    private String image;
    private String courseShortDesc;
   //getters and setters...

}

 List<SpinnerData> schedList = new ArrayList<SpinnerData>();

          /******* Firstly take data in model object ******/
        for(int z = 0; iter.hasNext(); z++) 
        {
            SpinnerDatasched= new SpinnerData();
            sched.setCourseName("Course: " + z+1);
            sched.setImage("image" + z+1);
            sched.setCourseShortDesc(iter.next());
            schedList.add(sched);
        }
SpinnerListModel spinnerListModel = new SpinnerListModel(schedList);