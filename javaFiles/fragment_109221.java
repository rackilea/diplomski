for (String header : conn.getHeaderFields().keySet()) {
   if (header != null) {
     for (String value : conn.getHeaderFields().get(header)) {
        System.out.println(header + ":" + value);
      }
   }
}