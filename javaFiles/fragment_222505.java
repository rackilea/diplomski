interface Callback {
    void updateText(String s);
}

public class  CallbackImpl implements Callback  {// implements this interface so that the caller can call text.setText(s) to update the text field.

    JTextField text;// This is the filed where you need to update on.

    CallbackImpl(JTextField text){//we need to find a way for CallbackImpl to get access to the JTextFiled instance, say pass the instance in the constructor, this is a way.
     this.text=text;
    }

    void updateText(String s){
         text.setText(s);//updated the text field, this will be call after getting the result from console.
    } 
}