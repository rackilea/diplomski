<%@page contentType="text/html" pageEncoding="UTF-8" import="java.io.*, java.util.*"%>

// adapted from: http://www.java2s.com/Code/Java/JSP/Printtherequestheadersandthesessionattributes.htm
   Enumeration enames = request.getHeaderNames();
   Enumeration pnames = request.getParameterNames();
   Map map = new TreeMap();

   while (enames.hasMoreElements()) {
      String name = (String) enames.nextElement();
      String value = request.getHeader(name);
      map.put(name, value);
   }
   while(pnames.hasMoreElements()) {
      String name = (String) pnames.nextElement();
      String value = request.getParameter(name);
      map.put(name, value);
    }

    out.println(createTable(map, "Request Headers"));