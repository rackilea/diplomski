private static void copy(InputStream is, OutputStream os) throws IOException
{
    byte buffer[] = new byte[8192];
    int bytesRead, i;

    while ((bytesRead = is.read(buffer)) != -1) {
        os.write(buffer, 0, bytesRead);
    }
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            FileInputStream baos = new FileInputStream(DOCUMENT_LOCATION);

            // set some response headers
            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            response.setContentType("application/pdf");
            response.setContentLength(new File(DOCUMENT_LOCATION).length());

            OutputStream os = response.getOutputStream();
            copy(baos, os);
            os.flush();
            os.close();

        }
    }