//Create both frames

JFrame frame1 = new JFrame("Frame1");
JFrame frame2 = new JFrame("Frame2");

//Add your buttons using a proper layout manager as suggested above
...
//Later in your code in your actionPerformed:
if (e.getSource.equals(b1)) {
    //To close the frame w/o exiting application
    frame1.dispose();
    frame2 = new JFrame("Frame2"); //Or call the method that creates this JFrame

    //To toggle frame visibility and not closing it
    frame1.setVisible(false);
    frame2.setVisible(true);
} else if (e.getSource.equals(b2)) {
    //To close the frame w/o exiting application
    frame2.dispose();
    frame1 = new JFrame("Frame2"); //Or call the method that creates this JFrame

    //To toggle frame visibility and not closing it
    frame2.setVisible(false);
    frame1.setVisible(true);
}