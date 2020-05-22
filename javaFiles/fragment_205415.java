public class Controller {
    public Model model;
    public void doSth(){
        model = new Model(); 
        model = MainActivity.model;
        System.out.println(model.getpName+"");

    }
}