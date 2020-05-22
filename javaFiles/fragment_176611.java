form = new BasicForm("Clear", "Calculate", "Quit");
buildForm();
boolean quitCalled=false;

for ( ; ; ) {
button = form.accept();

switch(button) {

case 0:
  form.clearAll();
  break;

case 1:
  // calculate code goes here
  break;

case 2:
  form.close();
  quitCalled = true;
  break;
}
if(quitCalled)
{
break;
}
}