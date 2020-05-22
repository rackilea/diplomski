private static void loadHtml(JEditorPane htmlc, JTextField url, String link) {
    try{
        htmlc.setPage(link);
        url.setText(link);
    }catch(Exception e){
        System.out.println("ops sorry could not find Virgin Mobile");
        e.printStackTrace();
    }
}