DefaultTableModel model=new DefaultTableModel()  
{
    public Class<?> getColumnClass(int column)  
    {
        switch(column)
        {
            case 0:                             // |This is the first column
                return Boolean.class;           // |First column is set to Boolean as it will contain check boxes
            case 1:                             // |This is the second column
                return String.class;            // |Second column set to String as it will contain strings
            default:
                return String.class;            // |The table is set to String as default 
        }   
    }
};