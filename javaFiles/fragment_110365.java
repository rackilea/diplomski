JFrame frame = new JFrame();
frame.getContentPane().add(new JScrollPane(new JTable(4, 3) {
  {
    getTableHeader().addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {
        int index = convertColumnIndexToModel(columnAtPoint(mouseEvent.getPoint()));
        if (index >= 0) {
          System.out.println("Clicked on column " + index);
        }
      };
    });
  }
}));

frame.pack();
frame.setVisible(true);