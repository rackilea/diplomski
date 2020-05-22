ap.selectXPath("/vdsDataSet/vdsData");
while((result = ap.evalXPath())!=-1){
    vn.push();
    vn.toElement(VTDNav.FC,"contractID");
    int i=-1;
    i= vn.getText(); //value for contractID here
    //vn.toElement(VTDNav.P);
    vn.toElement(VTDNav.NS);
    i=vn.getText(); 
    i= vn.getText(); // value for periodNum here
    vn.pop();
}