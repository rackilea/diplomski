void getCSSResources( List<URL> out ) 
    for ( Bundle b : context.getBundles() {
       Enumeration<URL> e = b.findEntries("myapp/resources", "*.css", true);
       while (e.hasMoreElements() {
          out.add(e.nextElement());
       }
     }
}