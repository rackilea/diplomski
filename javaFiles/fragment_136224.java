FileDialog fd = new FileDialog(new JFrame());
fd.setVisible(true);
File[] f = fd.getFiles();
if(f.length > 0){
    System.out.println(fd.getFiles()[0].getAbsolutePath());
}