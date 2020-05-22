@ProviderFor(JavacASTVisitor.class)
public class SomeHandler extends JavacASTAdapter
{
  @Override
  public void visitLocal(JavacNode localNode, JCTree.JCVariableDecl local)
  {
    local.mods.flags |= Flags.FINAL;

    if (local.vartype.toString().equals("int"))
      local.vartype = localNode.getTreeMaker().Ident(localNode.toName("Integer"));

    ...
  }
}