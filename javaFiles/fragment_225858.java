public class retImage extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException
    {
       ......
       // replace InputStream sImage with sImageBytes
       byte[] sImageBytes;
        try {           
            .....
            if(rs.next())
            {
                ...
                sImageBytes = rs.getBytes()

                response.setContentType("image/jpeg");
                response.setContentLength(sImageBytes.length);
                // Give the name of the image in the name variable in the below line   
                response.setHeader("Content-Disposition", "inline; filename=\"" + name+ "\"");

                BufferedInputStream  input = new BufferedInputStream(new ByteArrayInputStream(sImageBytes));
                BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream());

                byte[] buffer = new byte[8192];
                int length;
                while ((length = input.read(buffer)) > 0) {
                    output.write(buffer, 0, length);
                    System.out.println(".......3");
                }
            }
        }
        catch(Exception ex){
            System.out.println("error :"+ex);
        }
    }
}