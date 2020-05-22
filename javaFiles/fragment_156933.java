<%
    // application is JSP variable point to ServletContext instance

    InputStream is = application.getResourceAsStream("/WEB-INF/data.txt");

    BufferedReader b = new BufferedReader( new InputStreamReader( is ));

    out.println(br.readLine());
%>