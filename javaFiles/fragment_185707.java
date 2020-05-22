public void readBinaryAttachment(HTTPInputStream input) throws VTDException, IOException{
// first read xml bytes into XMLBytes
....
VTDGen vg = new VTDGen();
vg.setDoc(XMLBytes);
vg.parse(false);//
VTDNav vn = vg.getNav();
AutoPilot ap = new AutoPilot(vn);
ap.selectXPath("/ProcessRequest/BinaryAttachment/text()");
int i=0;
while((i=ap.evalXPath())!=-1){
   //i points to text node of 
   String s = vn.toRawString(i);
  // you need to decode them 
}

}