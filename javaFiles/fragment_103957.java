ClassLoader ldr = this.getClass().getClassLoader();
java.net.URL tickURL = ldr.getResource("tick.png");
java.net.URL crossURL = ldr.getResource("cross.png");

JPanel pnl = new JPanel();
ImageIcon tick = new ImageIcon(tickURL);     // <-- a URL is needed here, not a string
ImageIcon cross = new ImageIcon(crossURL);   // same here

JButton btn = new JButton("Click Me");
JButton tickBtn = new JButton(tick);
JButton crossBtn = new JButton("STOP", cross);