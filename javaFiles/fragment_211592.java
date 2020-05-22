public void onClick(View v){
TextView count = (TextView) ((v.getParent()).findViewById(R.id.counter));
switch(v.getId()){
case: R.id.incrementButton:
// increase value in count
break;
case R.id.decrementButton:
// decrease value in count
break;
}
}