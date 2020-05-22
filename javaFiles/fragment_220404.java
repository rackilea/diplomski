File inioutfile = new File(saveinijfc.getSelectedFile(), "");
//Insert here.
if(!inioutfile.exists()) {
    if(!inioutfile.createNewFile()) return;
}
Wini ini = new Wini(new File(inioutfile.getAbsolutePath()));