@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws     ServletException, IOException {
try{
    ServletFileUpload upload = new ServletFileUpload();
    FileItemIterator iterator = upload.getItemIterator(req);
    while (iterator.hasNext()) {
        FileItemStream item = iterator.next();
        InputStream stream = item.openStream();

        if (item.isFormField()) {
            byte[] str = new byte[stream.available()];
            stream.read(str);
            String pFieldValue = new String(str,"UTF8");

            if(item.getFieldName().equals("textBoxFormElement")){
                System.out.println("text Value : "+pFieldValue);
            }
          }
        }
}catch (Exception e) {
    e.printStackTrace();
}
}