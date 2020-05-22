public void rowSelected(SelectEvent event) {
    selectedPolyLrc = (Polylrc) event.getObject(); 
    RequestContext.getCurrentInstance().execute("alert( "+selectedPolyLrc.getId()+");");
    System.out.println("SELECTED AREA:" + selectedPolyLrc);
    //...
}