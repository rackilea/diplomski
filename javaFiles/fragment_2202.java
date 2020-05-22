private static final JTextField url = new JTextField(20);
private static final JEditorPane htmlc = new JEditorPane();
private static void loadHtml(String link) {
    try{
        htmlc.setPage(link);
        url.setText(link);
    }catch(Exception e){
        System.out.println("ops sorry could not find Virgin Mobile");
        e.printStackTrace();
    }
}