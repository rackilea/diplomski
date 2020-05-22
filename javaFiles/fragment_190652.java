class MyPanel extends JPanel{
    private String text;
    private Point[] vertextes;
    public void addVertext(..)
    public void paintComponent(Graphics g){
            ... use g to drawString, drawOval... according to 'text' and 'vertexes'
    }
}
// Then in your JFrame:
private MyPanel p;
...
actionPerfomred(...){
   p.addVertext(..)
   p.repaint();
}