List<String> sizes = new ArrayList<>();
    sizes.add("2T/3T");
    sizes.add("4T");
    sizes.add("5T");
    sizes.add("4");
    sizes.add("6");
    sizes.add("8");
    sizes.add("10");

    CheckComboBox cmbSizes = new CheckComboBox();
    ListCheckModel model = cmbSizes.getModel();
    cmbSizes.setTextFor(CheckComboBox.NONE, "*Please select size*");
    //cmbSizes.setTextFor(CheckComboBox.MULTIPLE,String.valueOf(model.getCheckeds()));
    for(String size:sizes){
        model.addElement(size);
    }
    model.addListCheckListener(new ListCheckListener() {

        @Override
        public void removeCheck(ListEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void addCheck(ListEvent arg0) {
            System.out.println(String.valueOf(model.getCheckeds()));

        }
    });