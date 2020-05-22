int selectedRow = m.getTable().getSelectedRow();
                //put data in updatedList
                for(int i = 0; i < m.getModel().getColumnCount(); i++)
                m.getOldValues().add(m.getTable().getValueAt(selectedRow, i));
                List oldvalue = ((List) ((ArrayList) m.getOldValues()).clone());
                m.getUpdatedList().put(selectedRow, oldvalue);
                System.out.println("updatedList: " + m.getUpdatedList());
              }