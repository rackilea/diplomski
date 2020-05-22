public class MyClass implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        // Do something when button is clicked
    }

    public void initOrSomething() {
        button.setOnClickListener(this);
    }
}