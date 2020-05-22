public List<DailySchedule> getDailySchedules(){
    SQLiteDatabase db = getReadableDataBase();
    Cursor dailyScheduleCursor = db.rawQuery(“Select * from daily_schedule ”);
    List<DailySchedule> all = new ArrayList<>();
    While(dailyScheduleCursor.next()){
        DailySchedule dailySchedule = new DailySchedule();
        dailySchedule.setId(dailyScheduleCursor.getLong(0));
        dailySchedule.setTasks(getTasks(dailyScheduleCursor.getLong(0)));
        dailySchedule.setPlans(getTasks(dailyScheduleCursor.getLong(0)));
        all.add(dailySchedule);
      }
    db.close();
}
public List<Task> getTasks(int id ){
    SQLiteDatabase db = getReadableDataBase();
    Cursor taskCursor = db.rawQuery(“Select * from tasks where id =’”+id+”’ ”);
    List<Task> all = new ArrayList<>();
    While(taskCursor.next()){
        Task task = new task();
        task.setId(taskCursor.getLong(0));
        // set other attributes     
        all.add(task);
    }
    db.close();
   return all;


}

public List<Plan> getPlan(int id ){

    getUser(id);// get all plans
    // set user
    return plans;
}
public User(int id){
       //create user from data
    return user;
}