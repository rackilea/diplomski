DefaultListModel<String> model;

private void UpdateJList(){
    model = new DefaultListModel<String>();
    for(Person p : personList){
         model.addElement(p.ToString());
    }    
    clientJList.setModel(model);     
    clientJList.setSelectedIndex(0);
}