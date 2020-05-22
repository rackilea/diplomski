public HttpServletResponse getFile (HttpServletRequest request ,HttpServletResponse httpServletResponse, .......){
          HttpServletResponse response = httpServletResponse;
          InputStream in =/*HERE YOU READ YOUR FILE AS BinaryStream*/

          String filename = "";
          String agent = request.getHeader("USER-AGENT");
          if (agent != null && agent.indexOf("MSIE") != -1)
          {
            filename = URLEncoder.encode(/*THIS IS THE FILENAME SHOWN TO THE USER*/, "UTF8");
            response.setContentType("application/x-download");
            response.setHeader("Content-Disposition","attachment;filename=" + filename);
          }
          else if ( agent != null && agent.indexOf("Mozilla") != -1)
          {
            response.setCharacterEncoding("UTF-8");
            filename = MimeUtility.encodeText(/*THIS IS THE FILENAME SHOWN TO THE USER*/, "UTF8", "B");
            response.setContentType("application/force-download");
            response.addHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
          }


          BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
          byte by[] = new byte[32768];
          int index = in.read(by, 0, 32768);
          while (index != -1) {
              out.write(by, 0, index);
              index = in.read(by, 0, 32768);
          }
          out.flush();

          return response;
}