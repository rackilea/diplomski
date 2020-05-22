public class HttpRequestHandler extends AsyncTask<String, String, String>{

    Command presenter;

    public <T extends Command> HttpRequestHandler(T presenter){
        this.presenter =  presenter;
    }

    presenter.execute("Success!");
}