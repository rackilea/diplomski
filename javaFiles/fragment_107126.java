public static void print(File file) {
    JFrame frame = new JFrame();
    JEditorPane pane= new JEditorPane();
    pane.setContentType("text/html");
    try{
        pane.setPage(file.toURI().toURL());
    }catch (IOException ex){
        System.out.println("MALFORMED ERROR!");
    }
    frame.add(pane);
    frame.setSize(200,200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    try{
        pane.print(null, null, false, PrintServiceLookup.lookupDefaultPrintService(), null, false);
    } catch (Exception e){
        System.out.println("PRINT ERROR!");
    }
}