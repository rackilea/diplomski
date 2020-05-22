public class Controller {
    private List<String> cssFiles;
    private List<String> jsFiles;
.......
 public Controller () {
        cssFiles = new ArrayList<String>();
        jsFiles = new ArrayList<String>();
        this.addCss("global");
        this.addJs("http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min");
        this.includejQueryUI();
        this.addJs("global");
    }