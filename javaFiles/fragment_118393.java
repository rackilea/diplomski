Random r = new Random();
for(int i = 0;i<=shapes.size()-1;i++){
    Shape s = shapes.get(i);
    Color c = new Color(r.nextInt(16777216));
    g.setPaint(c);
    g.fill(s);
    g.setPaint(Color.black);
    g.draw(s);
}