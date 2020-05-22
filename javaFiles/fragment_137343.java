class MVCExample
{
    public static void main(String[] args){
        MyModel model = new MyModel();
        MyView view = new MyView();
        MyController controller = new MyController(model, view);                
        controller.start();
    }
}