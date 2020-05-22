String jarFileName = ...
JarFile jar = new JarFile( jarFileName );
Enumeration<JarEntry> entries = jar.entries();
while ( entries.hasMoreElements() )
{
    JarEntry entry = entries.nextElement();
    String entryName = entry.getName();
    // do something with the entryName String
    ...

    // get an InputStream for the entry
    InputStream is = jar.getInputStream( entry );
    ...
}