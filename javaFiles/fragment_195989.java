String anyoString = "0";
NodeList nl = libroEle.getElementsByTagName("titulo");
if(nl != null && nl.getLength() > 0) {
   Element el = (Element)nl.item(0);
   anyoString = el.getAttribute("anyo");
}       
int anyo = Integer.parseInt(anyoString);