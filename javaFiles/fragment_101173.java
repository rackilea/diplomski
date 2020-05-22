interface Node { String evaluate(Map<String, String> metaData); }

class Group implements Node 
{
  private final List<Node> _children;

  Group(final List<Node> children) { _children = children; }

  @Override
  public String evaluate(final Map<String, String> metaData)
  {
    final StringBuilder sb = new StringBuilder(); 
    for (final Node node : _children)
    {
      final String subText = node.evaluate(metaData);
      if (subText == null)
        return null;
      sb.append(subText);
    }
    return sb.toString();
  }
}

class Text implements Node 
{
  private final String _text;

  Text(final String text) { _text = text; }

  @Override
  public String evaluate(final Map<String, String> metaData)
  {
    return _text;
  }
}

class Variable implements Node 
{
  private final String _variable;

  Variable(final String variable) { _variable = variable; }

  @Override
  public String evaluate(final Map<String, String> metaData)
  {
    return metaData.get(_variable);
  }
}