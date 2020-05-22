if (configloaded) 
  return;
File cfile = new File("oxconfig.properties");
try {
  if (cfile.createNewFile()) {
    try {
      FileOutputStream cout = new FileOutputStream(cfile);
      props.setProperty("names", "oxguy3, Player");
      props.setProperty("cloak_url", "http://...");
      ...
      cout.flush();
    } finally {
      cout.close();
    }
  } else {
    FileInputStream cin = new FileInputStream(cfile);
    try {
      props.load(cin);
    } finally {
      cin.close();
    }
  }
  configloaded=true;
} catch(IOException ex) {
  e.printStackTrace();
}