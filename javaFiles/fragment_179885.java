InputStream st = getServletContext().getResourceAsStream("/WEB-INF/imgs/cardbackground9.jpg");

OutputStream os = resp.getOutputStream();

if (st != null) {
       byte[] buf = new byte[4096];
       int nRead;
       while( (nRead=st.read(buf)) != -1 ) {
             os.write(buf, 0, nRead);
       }
       st.close();
}