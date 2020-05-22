public class NodeInfo implements Comparable<NodeInfo>
{
...

public int compareTo(NodeInfo other)
{
  String x = getName(this.line);
  String y = getName(other.line);
  return x.compareTo(y);
}
...
}