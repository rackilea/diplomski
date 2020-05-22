void DrawOverlay(String ping)
{
    lbl_ping.setText(ping);
    frame.getContentPane().validate(); // You modified child component lbl_ping (changed its size by setting a new text) so you need to recalculate all the child components
    frame.getContentPane().repaint(); // Redraws the content pane and all of its children
}