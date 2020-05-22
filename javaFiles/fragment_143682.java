public class runTests extends AsyncTask<Void, Void, Void> {
    @Override
    protected Void doInBackground(Void... params) { //sort this out

        results = runTest("CustomUseCase"); //i only want to run this one!!!
    }
    ...
}