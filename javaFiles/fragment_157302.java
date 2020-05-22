Random r=new Random();

String stars = "**********";
String total = "";
for (int z=0;z<5;z=z+1) {
    int x=1+r.nextInt(9);
    total = total+x+stars.substring(0, x)"\n";
}
JOptionPane.showMessageDialog(null,total);