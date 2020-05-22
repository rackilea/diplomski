String[] imageNames {"hello.jpg", "world.png", "!.gif"};
Random rand = rand = new Random();
....
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
{
    int index = rand.nextInt(3);

    Image im=new ImageIcon(this.getClass()
                .getResource("/images/" + imageNames[index])).getImage();
    ImageIcon iconLogo = new ImageIcon(im);
    jLabel2.setIcon(iconLogo);
}