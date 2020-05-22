Random r=new Random();

String stars = "";
String total = "";
for (int z=0;z<5;z=z+1) {
    stars = "";
    int x=1+r.nextInt(9);
    for(int i=0; i<x; i++)
    {
        stars = stars + "*";
    }
    total = total+x+stars"\n";
}
JOptionPane.showMessageDialog(null,total);