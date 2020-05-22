public class MyTable extends JTable {

    public MyTable(TableModel model){
        super(model);   
    }
    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int vColIndex){
        Component rComp=super.prepareRenderer(renderer, rowIndex, vColIndex);
        if(getModel()!=null){
            Client client=((ProfitAbilityTableModel)getModel()).getClient(rowIndex);
            if(client.getExpected()==client.getReceived())
                rComp.setBackground(new Color(139, 255, 182));
            else
                rComp.setBackground(new Color(255,139,147));
        }

        return rComp;
    }
}