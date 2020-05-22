for (String header : conn.getRequestProperties().keySet()) {
   if (header != null) {
     for (String value : conn.getRequestProperties().get(header)) {
        System.out.println(header + ":" + value);
      }
   }
}