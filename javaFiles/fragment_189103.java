public static Node processTree( Element elem ) {

     Node result;

     Elements elList = elem.getElementsByTag("ul");

     if ( elList == null || elList.size() == 0 ) {
         return null;
     };

     result = new Node();
     Element current = elList.first();
     elList = current.children();

     // Process LI elements and add them as content to the
     // result Node
     ...

     // Now go down the tree

     if ( elList != null && elList.size() != 0 ) {

        for ( Element el : elList ) {
            Node elTree = processTree( el );
            if ( elTree != null ) {
                result.addChild( elTree );
            }
        }
     }

     return result;
}