sendJSON(){
DataOutputStream out = new DataOutputStream(Controller.CheckerSocket.sout);
JsonGenerator jsonGenerator = new JsonFactory().createJsonGenerator(out);
-//-
}
receiveJSON(){
DataInputStream in = new DataInputStream(Controller.CheckerSocket.sin);
JsonParser jsonParser = new JsonFactory().createJsonParser(in);
-//-
}