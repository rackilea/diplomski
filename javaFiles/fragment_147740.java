public class Schedule {

  //Finds the first time slot during the day not yet assigned to a job.
  public Interval getFirstOpenTimeSlot() { /* ...*/ }

  public Interval getLargestOpenTimeSlot() { /* ...*/ }

  public ArrayList<Job> getJobsAssigned() {  /* ...*/ }

  //Returns the Interval the given job was assigned to or null if the job cannot fit
  // in the schedule.
  public Interval assignJob(Job theJob) {  /* ...*/ }

  //returns a list of all open time slots representing the time still available for jobs.
  public ArrayList<Interval> getAllOpenTimeSlots{ /*  */ }

}