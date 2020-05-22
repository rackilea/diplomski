public class FinalTableModel extends AbstractTableModel {

    private List<SI> li = new ArrayList();
    private String[] columnNames = { "Recipe", "Order", "Instruction",
                "Est.time", "Timer", "Timer Label", "Has Subinstructions"};

    public FinalTableModel(List<SI> list){
         this.li = list;
    }

    @Override
    public String getColumnName(int columnIndex){
         return columnNames[columnIndex];
    }

    @Override     
    public int getRowCount() {
        return li.size();
    }

    @Override        
    public int getColumnCount() {
        return 7; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SI si = list.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return si.getRecipe();
            case 1:
                return si.getMakingOrder();
            case 2:
                return si.getInstruction();
            case 3:
                return si.getEstimatedTimeInMinutesSeconds();
            case 4:
                return si.getTimerInMinutesSeconds();
            case 5:
                return si.getTimerEndingText();
            case 6:
                return si.isContainsOtherInstructions(); 
           }
           return null;
   }

   @Override
   public Class<?> getColumnClass(int columnIndex){
          switch (columnIndex){
             case 0:
               return String.class;
             case 1:
               return Integer.class;
             case 2:
               return String.class;
             case 3:
               return Double.class;
             case 4:
               return Double.class;
             case 5:
               return String.class;
             case 6:
               return Boolean.class;
             }
             return null;
      }
 }