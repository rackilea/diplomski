try{
    ClassLoader cl = Thread.currentThread().getContextClassLoader();
    Image image = ImageIO.read(cl.getResource("/Image/24/employeebg.png"));
    Image img = image.getScaledInstance(lbpicture.getWidth(),lbpicture.getHeight(),Image.SCALE_SMOOTH);
    ImageIcon imgicon=new ImageIcon(img);
    lbpicture.setIcon(imgicon);

}catch(Exception e){
    e.printStackTrace();
}