table.TableContainer.remove(table.ServiceTable);
table.add(table.ServiceTable, null);
table.ServiceTable.setModel(new javax.swing.table.DefaultTableModel( DataAct, Colnombs ));
table.ServiceTable.revalidate();
table.ServiceTable.repaint();
table.TableContainer.setViewportView(table.ServiceTable);