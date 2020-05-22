OnThreadCompleted listner;

public XMLParserThread(Context context, String fileName,
        OnThreadCompleted listner) {

    this.context = context;
    this.fileName = fileName;
    this.listner = listner;
}

@Override
public void run() {
   //listener.OnThreadCompleted() call is missing
}