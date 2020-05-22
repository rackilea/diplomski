cargoList.addListener(new ListChangeListener< CargoItem>(){
     public void onChanged(Change<? extends CargoItem> c){
         // Do your changes here
        System.out.println(c.getList()); 
        externalChoiceBox.getItems().setAll(cargoList);
     }});