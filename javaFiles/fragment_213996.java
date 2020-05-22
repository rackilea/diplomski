@Override
public void visitToken(DetailAST aAST)
{
    final DetailAST nameAST = aAST.getLastChild().getPreviousSibling();
    final FullIdent full = FullIdent.createFullIdent(nameAST);
    final String package = full.getText();


    // do some fancy stuff with package name
}