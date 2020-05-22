public class ScrollPanel extends JScrollPane {
    public ScrollPanel(GraphPanel gp){

         // ::::  HERE ::: you are not doing anything with gp 
         // like this.setViewPort( gp ) or something like that

        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.repaint();
    }
}