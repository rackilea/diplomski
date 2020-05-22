private MyListener listener = new MyListener();

void onStart(){
  bt.setOnClickListener(listener);
}

class MyListener implements OnClickListener
{ 
    String name;
    int value;

    void setName(String newName)
    {
        name = newName;
    }

    void setValue(int newValue)
    {
        value = newValue;
    }

    public void onClick(View v) 
    {
        // Use the data for some unknown purpose
    }
}