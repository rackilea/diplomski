private void onPaste(){
    Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
    Transferable t = c.getContents(this);
    if (t == null)
        return;
    try {
        jtxtfield.setText((String) t.getTransferData(DataFlavor.stringFlavor));
    } catch (Exception e){
        e.printStackTrace();
    }//try
}//onPaste