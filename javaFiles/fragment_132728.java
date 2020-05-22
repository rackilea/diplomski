public class SyncViewModel
{

...

public final Command beginSync = new Command(){

    private SyncAsyncTask task;

    @Override
    public void Invoke(View arg0, Object... arg1) {

        if( task == null || task.getStatus() == Status.FINISHED )
        {
            task = new CustomAsyncTask(customParams);
            task.execute();
        }

    }
};

public class CustomAsyncTask extends AsyncTask<Void, Void, String>{
    ....
    //Irrelevant implementation details
    ....
}