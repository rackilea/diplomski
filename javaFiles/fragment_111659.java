public class ConcreteAdapter extends AbstractAdapter < InfoClass, ConcreteAdapter.Cell > {

    public class Cell extends AbstractAdapter<InfoClass, ConcreteAdapter.Cell>.Cell {
        //...
    }

    @Override
    public void setData(Cell cell, int position) {
        InfoClass info = cell.info; 
    }

    //...
}