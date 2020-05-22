@Override
public void update(Observable o, Object arg) {
    mallUpdate = (Mall) o;
    DefaultListModel storeModel = new DefaultListModel();

    //Stores update
    for(int i = 0; i < mallUpdate.getStores().size();i++) {
        storeModel.addElement(mallUpdate.getStores().get(i));
    }
    // storesList.setModel(storeModel);//a JList variable
    thisFrame.setStoresListModel(storeModel);
}