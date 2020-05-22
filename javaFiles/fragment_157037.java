mv.setOnClickListener(new View.OnClickListener() {

@Override
public void onClick(View v) {
    // Just check whether the view is of your type or not.
    // If you are sure its gonna be MyView you can skip it
    if( v instanceof MyView) {
       MyView mv = (MyView)v;
       mv.yourCustomMethod();
    }

  }
});