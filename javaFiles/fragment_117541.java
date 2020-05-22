if (jTable.getSelectedRows() > -1) {

                 int[] selectedrows = jTable.getSelectedRows();

                 for (int i = 0; i < selectedrows.length; i++)
                {

                     System.out.println(jTable.getValueAt(selectedrows[i], 0).toString());

                }

            }