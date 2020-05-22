public class Button1Listener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        // Do something when button1 is clicked
    }
}

public class Button2Listener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        // Do something when button2 is clicked
    }
}


button1.setOnClickListener(new Button1Listener());
button2.setOnClickListener(new Button2Listener());