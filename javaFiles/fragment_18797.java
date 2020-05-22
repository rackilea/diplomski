XPathFactory f = XPathFactory.newInstance() ;
    XPath x = f.newXPath() ;
    try {
        InputSource source = new InputSource(new FileInputStream("logfile.xml")) ;
        XPathExpression expr = x.compile("//REPORT_DATA[DATA_ITEM='ENC'][last()]/VALUE/text()") ;
        String s = expr.evaluate(source) ;
        System.out.println("Last value: " + s ) ;
    }
    catch(Throwable t) {
        System.err.println("Error: " + t) ;
    }