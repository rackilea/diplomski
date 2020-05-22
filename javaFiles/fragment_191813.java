ServletContext application = ...;
File tmpdir = (File)application.getAttribute("javax.servlet.context.tempdir");

if(null == tmpdir)
  throw new IllegalStateException("Container does not provide a temp dir"); // Or handle otherwise

File targetFile = new File(tmpDir, "my-temp-filename.txt");
BufferedWriter out = null;

try {
  out = new BufferedWriter(new FileWriter(targetFile));

  // write to output stream
} finally {
  if(null != out) try { out.close(); }
  catch (IOException ioe) { /* log this */ }
}