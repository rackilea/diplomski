public String createWebPage( Thingy th ) {
    ...
    if (th instanceof Foo)
       return ((Foo)th).toHTMLString();
    if (th instanceof Bar)
       return ((Bar)th).toHTMLString();
    ...
 }