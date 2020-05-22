class MyController
{
    private MyModel model;  
    private MyView view;


    public MyController(MyModel model, MyView view){
        this.model = model;
        this.view = view;       
    }

    public void start(){
        int num = view.promptNumber();
        model.checkEvenOdd(num);
        view.displayResult(model.getOutcome());     
    }
}