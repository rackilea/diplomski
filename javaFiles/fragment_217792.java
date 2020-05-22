/******* Firstly take data in model object ******/
for(int z = 0; iter.hasNext(); z++) 
{
    SpinnerModel sched = new SpinnerModel();
    sched.setCourseName("Course: " + z+1);
    sched.setImage("image" + z+1);
    sched.setCourseShortDesc(iter.next());
    CustomListViewValuesArr.add(sched);
}