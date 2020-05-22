String savestr = "mysave.sav"; 
File f = new File(savestr);

PrintWriter out = null;
if ( f.exists() && !f.isDirectory() ) {
    out = new PrintWriter(new FileOutputStream(new File(savestr), true));
}
else {
    out = new PrintWriter(savestr);
}
out.append(mapstring);
out.close();