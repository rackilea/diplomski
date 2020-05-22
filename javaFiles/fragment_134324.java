int selectedRow = m.getTable().getSelectedRow();
                //put data in updatedList
                for(int i = 0; i < m.getModel().getColumnCount(); i++)
                    m.getOldValues().add(m.getTable().getValueAt(selectedRow, i));
                m.getUpdatedList().put(selectedRow, m.getOldValues());
                System.out.println("updatedList: " + m.getUpdatedList());
              }