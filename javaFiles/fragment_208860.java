public void init (){
    try {
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE );
        //dialog.add(comp)
        this.setModal(true) ;
        //dialog.setModalityType(dialog.DEFAULT_MODALITY_TYPE);
        this.setVisible(true);

    } catch (Exception e) {
        e.printStackTrace();
    }
}