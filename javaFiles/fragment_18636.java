Elements tableDatas = tableRow.getAllElements();

//Test if the the TableData contains Text, if so convert that text to a string rowData
         if (tableDatas.hasText()){
             String rowData = tableDatas.text();

             if (rowData.contains(testString)){
                 tableRowStrings.add(rowData);
             }

         }