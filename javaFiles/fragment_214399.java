java.util.Iterator it = nodes.getIterator();
int index = 0;
String literalJsArr = "[";
//populate the string with 'elem' and put a comma (,) after every element except the last 
while(it.hasNext()){
  literalJsArr += "'"+(String)it.next()+"'";
  if(it.hasNext() ) literalJsArr += ",";
  index++;
}
literalJsArr += "]"; 
architectView.callJavascript("World.drawPath("+literalJsArr+")");