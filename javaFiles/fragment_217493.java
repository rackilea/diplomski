JFrame jf = new JFrame("StandardPrint Test");
    final JTextArea area = new JTextArea();
    area.append("hello\n");
    for (int i = 0; i < 50; i++) {
        area.append("\n");
    }
    area.append("world\n");
    JScrollPane sp = new JScrollPane(area);
    jf.add(sp);
    JMenuBar bar = new JMenuBar();
    JMenu printMenu = new JMenu("Print");
    JMenuItem print = new JMenuItem("Print");
    printMenu.add(print);
    ActionListener al = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            StandardPrint sp = new StandardPrint(area);
            sp.setTitle("Hello World");
            sp.setPrintPageNumber(true);
            sp.setPageNumberVAlignment(BOTTOM);
            sp.setPageNumberHAlignment(CENTER);
            System.out.println(sp.getNumberOfPages());
            Image im1 = preview(300,300, sp, sp.getPageFormat(0), 0);
            Image im2 = preview(300,300, sp, sp.getPageFormat(1), 1);
            JLabel l = new JLabel(new ImageIcon(im1));
            JOptionPane.showMessageDialog(null, l);
            l = new JLabel(new ImageIcon(im2));
            JOptionPane.showMessageDialog(null, l);
        }
    };
    print.addActionListener(al);
    jf.setJMenuBar(bar);
    bar.add(fm);
    bar.add(printMenu);
    jf.setBounds(100,100,400,400);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setVisible(true);
}