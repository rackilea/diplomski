MouseListener tableMouseListener = new MouseAdapter() {

                  @Override
                  public void mouseReleased(MouseEvent e) {
                      String data = null;
                      int[] rows = jt.getSelectedRows();
                      int[] columns = jt.getSelectedColumns();
                      for (int i = 0; i < rows.length; i++) {
                            for (int j = 0; j < columns.length; j++) {
                                data = (String) jt.getValueAt(rows[i], columns[j]);
                                System.out.println("Table element selected is " + data);
                            }
                      }
                  }
               };
               jt.addMouseListener(tableMouseListener);