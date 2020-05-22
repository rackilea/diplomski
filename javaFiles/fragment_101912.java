Pipe P = new Pipe (fname,x1name,x2name,x3name,oname);
try {
    view.setText(P.Pipeit());
} catch (TransformerConfigurationException e) {
    //log/handle the exception
} catch (TransformerException e) {
    //log/handle the exception
} catch (SAXException e) {
    //log/handle the exception
} catch (IOException e) {
    //log/handle the exception
}