for(int i=0; i<CompTable.getRowCount(); i++){
         String value = ((Comp)CompTable.getValueAt(i, 0)).lower;
         if(value!= null && !value.isEmpty()){
               plist.add(value);
         }
   }