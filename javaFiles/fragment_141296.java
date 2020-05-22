ImageIcon SD = new ImageIcon("resources/terrains/StoneDungeon.jpg");
JLabel dns=new JLabel( SD);
    frame.getContentPane().add(dns);
    dns.setBounds(800,150,50,50);
    dns.setFont(new Font("Courior", Font.BOLD, 25));
    dns.setForeground(Color.red);
    dns.setTransferHandler(new TransferHandler("icon"));
    MouseListener ml = new MouseAdapter(){
        public void mousePressed(MouseEvent e){
            JComponent jc = (JComponent)e.getSource();
            TransferHandler th = jc.getTransferHandler();
            th.exportAsDrag(jc, e, TransferHandler.COPY);
        }
    };
    dns.addMouseListener(ml);