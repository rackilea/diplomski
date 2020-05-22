public class setTextClass {

    private TextView textView;
    private String text; // You have to declare your global variables here

    public void setTextClass (TextView textView, String text){ // You should pass your TextView in the constructor and assign it to your global variable, so it's not null when you assign text to it;
       this.textView = textView;
       this.text = text;
       textview.setText(text); // Moved from your onCreate method to the constructor
    }

    public void run{
        textview.setText(text);
    }
}