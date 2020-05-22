public class Pojo{
    private Data data;

    public void setData(Data data){
        this.data = data;
    }
    public Data getData(){
        return this.data;
    }

public class Data {
    private Text text;

    public void setText(Text text){
        this.text = text;
    }
    public Text getText(){
        return this.text;
    }
}

public class Text {
    private Loading loading;

    public void setLoading(Loading loading){
        this.loading = loading;
    }
    public Loading getLoading(){
        return this.loading;
    }
}

public class Loading {
    private String intro_text;

    public void setIntro_text(String intro_text){
        this.intro_text = intro_text;
    }
    public String getIntro_text(){
        return this.intro_text;
}