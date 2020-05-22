...
   // create an instave variable called parent so you can access the other class
 private SomeClassThatHasAMethodYouWantToCall parent;

 static CardFragment newInstance(SomeClassThatHasAMethodYouWantToCall parent) {
        CardFragment cf = new CardFragment();
         this.parent = parent;
        return f;
    }


 // then in onCreateView
   pubklic  View OnCreateView()
{
   View myView = infalter.inflate(containter , R.layout.myCard, false);
   Button b = myView.findViewById(R.id.Mybutton);
   b.setOnClickListener(v -> callMethod()); // shortened for brevity
   return myView;
}

  private void callMethod(){
       parent.callTheMethodYouWantInTheOtherClass();
  }