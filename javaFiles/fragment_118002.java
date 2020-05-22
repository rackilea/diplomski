PrintWriter out = response.getWriter();
           response.setContentType( "text/html");

           // output the result
           out.println( "<html><head><title>Hello</title></head>");
           out.println( "<body><h1>Hello, is it me you're looking for ?</h1>" );   
           out.println( "<img src=\"/files/LionelRichie.jpg\">" ); 
           out.println( "</body></html>");
           out.close();