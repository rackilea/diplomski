public class DrawingPanel extends JPanel {
    List<Drawable> drawList;
    // Map<String, Drawable> drawMap;

    public void addToDrawList(Drawable drawable) { 
        drawList.add(drawable);
        repaint();
    }

    // public void addToDrawMap(String key, Drawable drawable) {
    //     drawMap.put(key, drawable);
    //     repaint();
    // }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Drawable drawable : drawList){
            drawable.draw(g);
        }

        // for (Drawable drawable : drawMap.values()) {
        //     drawable.draw(g);
        // }
    }
}