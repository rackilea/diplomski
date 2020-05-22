InputStream in = ...   // get your XML InputStream
DOCTYPEChangerStream changer = new DOCTYPEChangerStream(in);
changer.setGenerator( 
    new DoctypeGenerator() {
        public Doctype generate(Doctype old) {
            return new DoctypeImpl("rootElement", "pubId", "sysId", "internalSubset");
        }
    } 
);
// .. and pass it on to the parser.