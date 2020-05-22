public void start(){
    getBox_Topics().setBorder(new TitledBorder(new EtchedBorder(),"Topics of vote"));
    setScrollPane(new JScrollPane(getBox_Topics()));
    add(getScrollPane());
    getScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    getBox_Topics().addContainerListener(new ContainerListener() {
        @Override
        public void componentAdded(ContainerEvent containerEvent) {
            getScrollPane().revalidate();
            getScrollPane().repaint();
        }

        @Override
        public void componentRemoved(ContainerEvent containerEvent) {

        }
    });
    pack();
    setHandler(new ClientHandler_Thread(this));
    getHandler().start();
    setVisible(true);
}