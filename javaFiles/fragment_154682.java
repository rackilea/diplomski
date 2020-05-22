public class SelectionClass extends Composite implements HasSelectionHandlers<Integer>{

    //...   

    private void somethingHappens(int i){
            SelectionEvent.<Integer>fire(this, i);
    }       

    @Override
    public HandlerRegistration addSelectionHandler(SelectionHandler<Integer> handler) {
            return super.addHandler(handler, SelectionEvent.getType());
    }       

}