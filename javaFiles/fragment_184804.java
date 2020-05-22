if (e.getKeyCode() == KeyEvent.VK_ENTER) {

    log.add(new ServerBubble(input.getText()));
    log.add(Box.createRigidArea(new Dimension(0, 10)));
    input.setText(null);
    log.revalidate();

    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            Dimension vpSize = scrollPane.getViewport().getExtentSize();
            Dimension logSize = log.getSize();

            int height = logSize.height - vpSize.height;
            scrollPane.getViewport().setViewPosition(new Point(0, height));
        }
    });
}