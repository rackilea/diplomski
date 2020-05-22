byte[] pageInBytes = readAllBytesFromTheURL();
VTDGen vg = new VTDGen();
vg.setDoc(pageInBytes);
vg.parse(false);
VTDNav vn = vg.getNav();

AutoPilot ap = new AutoPilot(vn);

//Jump to the section that we want to process
ap.selectXPath("/html/body/div");
String fileId = vn.toString(vu.getElementFragment());