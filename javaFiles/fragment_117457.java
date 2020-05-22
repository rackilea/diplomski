public class MyResponse{
    String title;
    ArrayList<sections>;
}

public class sections{
    int toclevel;
    String level;
    String line;
    String number;
    String fromtitle;
    long byteoffset;
    String anchor;
}



public class WikiResponseParse{
    Parse parse;
    public class Parse{
        String title, text;
    }
}