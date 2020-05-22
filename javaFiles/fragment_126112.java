public interface BoxType {
  public <R> R accept(BoxTypeVisitor<R> visitor);
}

public class BlockNode implements BoxType {
  public final StyledNode styledNode;

  public BlockNode(StyledNode styledNode) {
    this.styledNode = styledNode;
  }

  @Override
  public <R> R accept(BoxTypeVisitor<R> visitor) {
    visitor.visit(this);
  }
}

public class InlineNode implements BoxType {
  public final StyledNode styledNode;

  public InlineNode(StyledNode styledNode) {
    this.styledNode = styledNode;
  }

  @Override
  public <R> R accept(BoxTypeVisitor<R> visitor) {
    visitor.visit(this);
  }
}

public class AnonymousBlock implements BoxType {
  @Override
  public <R> R accept(BoxTypeVisitor<R> visitor) {
    visitor.visit(this);
  }
}

public interface BoxTypeVisitor<R> {
  public R visit(BlockNode box);
  public R visit(InlineNode box);
  public R visit(AnonymousBlock box);
}