public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(() -> {
        JFrame frame =new JFrame();
        JTextArea area = new JTextArea();
        JScrollPane pane = new JScrollPane(area);

        frame.add(pane);
        frame.setPreferredSize(new Dimension(400,400));
        frame.pack();
        frame.setVisible(true);
        long t1 = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) {
            area.append(i+"\n");
        }
        long t2 = System.currentTimeMillis();
        System.out.println("(t2-t1) = " + (t2-t1));
        StringBuilder sb = new StringBuilder(); 
        long t3 = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) {
            sb.append(i+"\n");
        }
        long t4 = System.currentTimeMillis();
        area.setText(sb.toString());
        System.out.println("(t4-t3) = " + (t4-t3));

    });
}