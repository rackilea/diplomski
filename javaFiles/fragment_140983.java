TableColumn columnmod = new TableColumn<ModuleNoteBean, Double>(
                moBean.getModuleBean());
        for (int i = 0; i < moBean.getListmat().size(); i++) {
            TableColumn columnNote = new TableColumn(moBean.getList_mat()
                    .get(i));
            final int index = i;
            columnNote
                    .setCellValueFactory(new Callback<CellDataFeatures<ModuleNoteBean, String>, ObservableValue<String>>() {

                        public ObservableValue<String> call(
                                CellDataFeatures<ModuleNoteBean, String> p) {

                            SimpleStringProperty b = new SimpleStringProperty(p
                                    .getValue().getModuleNList().get(0)
                                    .getNoteList().get(index)
                                    + "");

                            return b;
                        }
                    });