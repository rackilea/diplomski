public class MyTableModel extends DefaultTableModel {

    private static final long serialVersionUID = -8422360723278074044L;

    MyTableModel(Object[][] data, Object[] columnNames )    
    {
      super(data,columnNames);
    }

    public boolean isCellEditable(int row,int cols)
     {
       if(cols==1 ){return true;}
          return false;                                                                                    
     } 
}