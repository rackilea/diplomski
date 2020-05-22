for( Element element : media )
{
    final String src = element.absUrl("src");

    if( src.toLowerCase().endsWith(".jpg") ) // only needed if you want to check only jpegs
    {
        final URL url = new URL(src);
        final long size = url.openConnection().getContentLength();

        System.out.println(element + " ---> " + size + " byte");
    }
}