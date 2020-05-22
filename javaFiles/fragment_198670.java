public class Form {
    JFrame frm;

    public void init(String title){
        frm = new JFrame(title);
    }

    public void doSomething(){
        frm.doSomething();
    }
}

public class Form_child{
    JInternalFrame frm;

    public void init(String title){
        frm = new JInternalFrame(title);
    }

    public void doSomething(){
        frm.doSomething();
    }
}