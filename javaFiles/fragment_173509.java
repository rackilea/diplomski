public class FileTransferHandler extends TransferHandler {

    @Override
    protected Transferable createTransferable(JComponent c) {
        List<File> files = new ArrayList<File>();
        // copy your files from the component to a concrete List<File> files ...
        // the following code would be a sample for a JList filled with java.io.File(s) ...
        /*JList list = (JList) c;
        for (Object obj: list.getSelectedValues()) {
            files.add((File)obj);
        }*/
        return new FileTransferable(files);
    }

    @Override
    public int getSourceActions(JComponent c) {
        return MOVE;
    }
}