class UploadButtonListener implements ActionListener{
    private View view;
    public UploadButtonListener(View view){
        this.view = view;
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        String filename = view.getFileName();
        if(!filename.isEmpty()){
                    ... your logic
            }
    }

}