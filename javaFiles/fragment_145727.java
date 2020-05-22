String[] sentences=new String[3];
    sentences[0]="Hi";
    sentences[1]="Hello";
    sentences[2]="How r u?";

    Gson gson=new GsonBuilder().create();
    String jsonArray=gson.toJson(sentences);

    //["Hi","Hello","How r u?"]

    out.write(jsonArray);
    out.flush();
    out.close();