public static void myPrintMethod(Graphics g){
    g.drawString("myPrintMethod",20,40); 
}
public void paint(Graphics g){
    g.drawString("Paint method",20,20);
    myPrintMethod(g);
}