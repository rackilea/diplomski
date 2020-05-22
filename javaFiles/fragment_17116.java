public Gui(){
   this("");
}

public Gui(String t){
   //instruct (I am not sure what it means)

   quesHandText = new JTextField(4);
   classParticular handler1 = new ClassParticular();
   particular.addActionListener(handler1);

   myVector = new String[2]; // or some other size you need.
   myVector[0]="some_string";
   myVector[1]="some_string2";
}