private JtextArea ta;
public AppletTest() throws HeadlessException {
    super();
    TransferHandler tf = new TransferHandler(){
        //code as above
        @Override
        public boolean canImport(TransferSupport arg0) {

            for (DataFlavor df:  arg0.getDataFlavors() ){
                if (df.isFlavorJavaFileListType() ){
                     return true;
                }
            }
            //we only accept files
            return false;
        }


        @Override
        public boolean importData(TransferSupport arg0) {
            try {
            @SuppressWarnings("unchecked")
                List<File> oList = (List<File>) arg0.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                 //check that you don't have multiple files selected
                if (oList.size() == 1){
                    File myFile = oList.get(0);
                    ta.setText(myFile.toString() );
                }
            } catch (UnsupportedFlavorException e) {
                e.printStackTrace();
            } catch (IOException e) {
            e.printStackTrace();
            }
            return super.importData(arg0);
        }
    };

    ta = new JTextArea();
    this.add(ta);   
    ta.setTransferHandler(tf);

}