//first we need an Iterator to iterate through the list
java.util.Iterator it = nodes.getIterator();
//we'll need the 'window' object to eval a js array, you may change this
//I dont know if you are using an applet or a javaFX app. 
netscape.javascript.JSObject jsArray = netscape.javascript.JSObject.getWindow(YourAppletInstance).eval("new Array()");
//now populate the array 
int index = 0;
while(it.hasNext()){
  jsArray.setSlot(index, (String)it.next());
  index++;
}
//finaly call your function
netscape.javascript.JSObject.getWindow(YourAppletInstance).call("World.drawPath",new Object[]{jsArray});