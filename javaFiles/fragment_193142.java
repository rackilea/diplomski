MyAsyncTask task = new MyAsyncTask();
task.execute();
if (task.get() != null) // waiting for it
{
    Log.d("placesSuggestion", Arrays.toString(placesSuggestion));
}