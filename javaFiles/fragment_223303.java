public class A {

    private String url;

    public A(WebDriver driver){       
        url = driver.getCurrentUrl();
        System.out.println("The current URL is:"+url);
        Util.wait(5);
    }

    public void setUrl(String url) {    //THIS IS A SETTER
        this.url = url;
    }

    public String getUrl() {            //THIS IS A GETTER
        return this.url;
    }

}