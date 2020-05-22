public class ScrollPane extends Window{
    Window component;
    void renderScrollBar(){
        Graphics g = window.getGraphicsHandle();
        g.drawRectangle(/** some coords for where to put the bar **/);
        /** some extra code to add logic on the scroll bar,
        /** such as shifting the Window content up or down and cull out
        /** the portion that is outside of the ScrollPane.
        /** For example, openGL could allow you to do this with scissor 
        /** test **/
    }

    void render(){
        component.render();
        this.renderScrollPane();
    }
}