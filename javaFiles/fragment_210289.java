class Parser {
    private ParsingFinishedListener callback;

    public Parser(ParsingFinishedListener c) {
        this.callback = c;
    }

    //some code

    public void parse(String stuffToParse) {
         //code
         callback.onTextParsed(parsedText);
    }

    public interface ParsingFinishedListener {
         public void onTextParsed(String textToVizualize);
    }
}

class MyTask extends AsyncTask<Void, Void, Void> {
    private ParsingFinishedListener callback;         
    public MyTask(ParsingFinishedListener c) {
        this.callback = c;
    }

    ..doInBackground..

    ..onPostExecute(String result) {
        Parser p = new Parser(callback);
        p.parse(result);
    }
}

class MyActivity extends Activity implements ParsingFinishedListener {

    ...onCreate(...) {
        ...
        MyTask task = new MyTask((ParsingFinishedListener) this);
        task.execute();
    }
    //some code

    @Override
    public void onTextParsed(String result) {
         //do something with the result
    }

}