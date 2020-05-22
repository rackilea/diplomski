public void doAfterCompose(Component comp) throws Exception {
    super.doAfterCompose(comp);

    for(int i=0;i<=10;i++){
        Listitem li = new Listitem();
        Listcell lic = new ListCell();
        li.appendChild(lic);
        Button myBtn = new Button("Btn");
        myBtn.setParent(lic);

        //...

    }
}