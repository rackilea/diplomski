DemoAsyncTask task = new DemoAsyncTask(new AsyncTaskListener(){
@Override
public void on onTaskCompleted(Object<Type> value);{
//do your second step here
})
};
task .execute();