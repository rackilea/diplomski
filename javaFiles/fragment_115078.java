private static ObservableList<ObjectB> getListObjectB() {
        ObservableList<ObjectA> lstObjectA =  getLstObject;
        ObservableList<ObjectB> lstObjectB = new FXCollection.observableArraylist();
        for (int i =0;i<lstObjectA.size();i++) {
            lstObjectB.add(lstObjectA.getObjectB());
        }
        return lstObjectB
    }