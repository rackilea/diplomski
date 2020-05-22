public void valueChanged(ListSelectionEvent event) {
             int selRow = animalTable.getSelectedRow()
             if(selRow >= 0)
             {
                System.out.println(animalTable.getValueAt(selRow, 0));
                // or do other things
             }
         }