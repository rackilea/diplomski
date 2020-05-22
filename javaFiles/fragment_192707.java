public static void main(String []args){
    StringBuffer a = new StringBuffer("a"); //Create StringBuffer a
    StringBuffer b = new StringBuffer("b"); //Create StringBuffer b
    StringChain chain = new StringChain(new StringBuffer[] { a, b }); //Pass both buffers to the String Chain
    System.out.println(chain);
    setStringBufferValue(b, "c");
    System.out.println(chain);
 }

 private static void setStringBufferValue(StringBuffer buf, String value) {
     buf.replace(0, buf.length(), value);
 }