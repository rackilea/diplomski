public static <S> Iterable<S> getService(
    File jar, ClassLoader loader, Class<S> service) {

  ArrayList<S> list=new ArrayList<>();
  String name=service.getName();
  try(JarFile f=new JarFile(jar)) {
    JarEntry entry = f.getJarEntry("META-INF/services/"+name);
    if(entry==null) return Collections.emptyList();
    try(BufferedReader r=new BufferedReader(new InputStreamReader(
        f.getInputStream(entry), "UTF-8"))) {
      Matcher m=Pattern.compile(
        "[ \\t]*(\\p{javaJavaIdentifierStart}[\\p{javaJavaIdentifierPart}.]*)?[ \t]*(?:#.*)?")
        .matcher("");
      for(String s=""; s != null; s=r.readLine()) {
        if(s.trim().length()==0) continue;
        if(m.reset(s).matches()) {
          String found=m.group(1);
          if(found!=null) try {
            list.add(loader.loadClass(found).asSubclass(service).newInstance());
          }
          catch(Throwable e) {
            log(Level.SEVERE, found, e);
            return null;
          }
        } else log(Level.WARNING, "malformed spi decl: {0}", s);
      }
    }
  } catch(IOException ex) {
    log(Level.SEVERE, name, ex);
    return Collections.emptyList();
  }
  return list;
}
static void log(Level level, String msg, Throwable thrown)
{
  Logger.getLogger("insert logger name here").log(level, msg, thrown);
}
static void log(Level level, String msg, Object arg)
{
  Logger.getLogger("insert logger name here").log(level, msg, arg);
}