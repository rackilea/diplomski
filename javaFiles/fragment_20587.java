}if(found != true){

        lvListView.setStyle("-fx-font-size:18.0;-fx-background-color: white;");
        for(indexSC = 0; indexSC < simpleArray.length;indexSC++){
        if(simpleArray[indexSC].toLowerCase().contains(txtTest.getText().trim().toLowerCase())){
        // array stream foreach filter results to textarea javafx
        List<String> cs = Arrays.asList(simpleArray);

        ArrayList list = new ArrayList<>();
        cs.stream().filter(s -> s.startsWith("someon"))
          //.forEach(System.out::println); 
        .forEach(list :: add);   
        //String aL = list.toString();
        //System.out.println("!!!! aL "+aL);
        //La = list.toString().replace("[", "").replace("]","").replace(",", "").replace(" ", "\n");
        int L = list.size();
        for(int X = 0; X < L;X++){
        String A = (String) list.get(X);
        cboSP.getItems().add(A);
        txaML.appendText(A);
        txaML.appendText("\n");
        lvListView.getItems().add(A);
        System.out.println(" = = L "+L+" Num "+A);
        }

        lvListView.getSelectionModel().selectedItemProperty()
        .addListener((observable, oldValue, newValue) -> {
        System.out.println(newValue);});