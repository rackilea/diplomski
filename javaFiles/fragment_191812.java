ServletContext application = ...;
InputStream in = null;

try {
  in = application.getResourceAtStream("/WEB-INF/web.xml"); // example

  // read your file
} finally {
  if(null != in) try { in.close(); }
   catch (IOException ioe) { /* log this */ }
}