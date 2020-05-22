table.addAncestorListener(new AncestorListener(){
    @Override
    public void ancestorAdded(AncestorEvent event){
        tweakColumns(table);
    }

    @Override
    public void ancestorRemoved(AncestorEvent event){

    }

    @Override
    public void ancestorMoved(AncestorEvent event){

    }
})