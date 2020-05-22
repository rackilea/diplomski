URL toOpen = new URL(intent.getData().toString());
    String text = noteHandler.loadNote(toOpen);

public String loadNote(URL note){
    String content = "";

    try {
        InputStream is = note.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        ....