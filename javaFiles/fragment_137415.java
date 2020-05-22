@Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

    Object obj = table.getValueAt(row, 5);//
    String redGreen = (String)obj;
    //pinta red/green        
    if(column == 5 && redGreen == "RED"){                      
        label.setBackground(Color.red);
    }else if(column == 5 && redGreen == "GREEN"){
        label.setBackground(Color.green);
    }
    // No default fall through functionality
    // for the other columns


    return label;
}