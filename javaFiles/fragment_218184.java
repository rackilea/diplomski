private void doDownload( HttpServletRequest req, HttpServletResponse resp,String filename, String original_filename )throws IOException
            {
            File f = new File(filename);
            int  length   = 0;
            ServletOutputStream op = resp.getOutputStream();
            ServletContext context  = getServletConfig().getServletContext();
            String  mimetype = context.getMimeType( filename );
            resp.setContentType( (mimetype != null) ? mimetype : "application/octet-stream" );
            resp.setContentLength( (int)f.length() );
            resp.setHeader( "Content-Disposition", "attachment; filename=\"" + original_filename + "\"" );
            byte[] bbuf = new byte[BUFSIZE];
            DataInputStream in = new DataInputStream(new FileInputStream(f));
            while ((in != null) && ((length = in.read(bbuf)) != -1)){
            op.write(bbuf,0,length);
            }
            in.close();
            op.flush();
            op.close();
        }