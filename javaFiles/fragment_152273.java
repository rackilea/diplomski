class MyObj {
    public String name;
    public double price;
}

class MyTableModel extends AbstractTableModel {

    private List<MyObj> contents;

    public MyTableModel(List<MyObj> contents){
        this.contents = contents;
    } 

    @Override
    public int getRowCount(){
        return this.contents.size();
    }

    @Override
    public int getColumnCount(){
        return 2;
    }

    @Override
    public Object getValueAt(int row, int column){
        MyObj myObj = contents.get(row);

        //map column index to property
        return (column == 0)? myObj.name : myObj.price;
    }
}