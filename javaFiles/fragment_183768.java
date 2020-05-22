public abstract class Browser { // make it abstract because you cant make a browser that's not ch
    public Browser() {
        //does stuff...
    }

    public void launch(String url) {
        //launches browser from WebDriver object
    }

    public void close () {
        //closes browser from WebDriver object
    }
}

public class Browser_Chrome extends Browser {
    public Browser_Chrome() {
        super();
        // WebDriver specifics...
    }
}

public class Browser_Firefox extends Browser {
    public Browser_Firefox() {
        super();
        // WebDriver specifics...
    }
}


public class webApp {
    private Browser borwser; 
    public webAbb(Browser borwser) {
        super();
        this.borwser= borwser;
    }

    public void lunchBrowser(){
       borwser.lunch();
    }

}