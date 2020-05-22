// This is a BoxLayout with top to bottom orientation, the trick is to nest many JPanel
// with BoxLayout in both the direction to have all working
// What I want to achieve is:
//
//     1. Having a main box top to bottom where I will put:
//           - Top margin (a rigid area with dimension (0,MARGIN)
//           - Main JPanel with BoxLayout and LINE_AXIS (left to right) orientation
//           - Bottom margin (a rigid area like top margin)
//
//     2. In the main panel I will put:
//           - Left Margin (a rigid area with dimensions (MARGIN,0)
//           - A JPanel (leftPanel) Boxed top to bottom containing the things on the left that actually are jLabel3 and jLabel2
//           - A little separator between the two panel, a rigid area (10,0) i.e.
//           - A JPanel (rightPanel) Boxed top to bottom containing the remaining 4 JLabels
//           - Right Margin (as left)
//
//     3. In rightPanel JPanel (BoxLayout.PAGE_AXIS, top to bottom) I will have:
//           - a rigid area space to match the position that I want
//           - the first label
//           - a rigid area.. etc so on
//     
//     For each JLabel I must set all:
//           - setPreferredSize(dimension)
//           - setMinimumSize(dimension)
//           - setMaximumSize(dimension)
//
//     Then, if you specify also the JFrame is better, but you can try to pack().
//     BoxLayout take care of sizes, not exceeding maximum and not making it smaller than minimum. Yust try it and you will love it.

getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS);

JPanel main = new JPanel();
main.setLayout(new BoxLayout(main, BoxLayout.LINE_AXIS));

this.add(Box.createRigidArea(new Dimension(0,20))); // VERTICAL SPACE (top margin)
this.add(main);
this.add(Box.createRigidArea(new Dimension(0,20))); // VERTICAL SPACE (bottom margin)

JPanel rightPanel = new JPanel();
rightPanel.setLayout( new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
JPanel leftPanel = new JPanel();
leftPanel.setLayout( new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));

main.add(Box.createRigidArea(new Dimension(20,0))); // HORIZONTAL SPACE (left margin)
main.add(leftPanel);
main.add(Box.createRigidArea(new Dimension(10,0))); // HORIZONTAL SPACE (between the two)
main.add(rightPanel);
main.add(Box.createRigidArea(new Dimension(20,0))); // HORIZONTAL SPACE (right margin)

// now you should have understood how it works, just try to fill the right and left panel with your labels. Remember to set preferredm, maximum and minimum sizes.