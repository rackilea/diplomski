import java.util.HashMap;
import java.util.ArrayList;

class Node {
  // static lookup table, because we *could* try to find nodes by walking
  // the node tree, but the ids are uniquely identifying: this way we can
  // do an instant lookup. Efficiency!
  static HashMap<Long, Node> NodeLUT = new HashMap<Long, Node>();

  // we could use Node.NodeLUT.get(...), but having a Node.getNode(...) is nicer
  public static Node getNode(long id) {
    return Node.NodeLUT.get(id);
  }

  // we don't call the Node constructor directly, we just let this factory
  // take care of that for us instead.
  public static Node create(long _id, String _label) {
    return new Node(_id, _label);
  }

  public static Node create(long _id, String _label, long _parent) {
    Node parent = Node.NodeLUT.get(_parent), node;
    node = new Node(_id, _label);
    parent.addChild(node);
    return node;
  }

  // instance variables and methods

  Node parent;
  long id;
  String label;
  ArrayList<Node> children = new ArrayList<Node>();

  // again: no public constructor. We can only use Node.create if we want
  // to make Node objects.
  private Node(long _id, String _label) {
    parent = null;
    id = _id;
    label = _label;
    Node.NodeLUT.put(id, this);
  }

  // this is taken care of in Node.create, too
  private void addChild(Node child) {
    children.add(child);
    child.setParent(this);
  }

  // as is this.
  private void setParent(Node _parent) {
    parent = _parent;
  }

  /**
   * Find the route from this node, to some descendant node with id [descendentId]
   */
  public ArrayList<Node> getDescendentPathTo(long descendentId) {
    ArrayList<Node> list = new ArrayList<Node>(), temp;
    list.add(this);
    if(id == descendentId) {
      return list;
    }
    for(Node n: children) {
      temp = n.getDescendentPathTo(descendentId);
      if(temp != null) {
        list.addAll(temp);
        return list;
      }
    }
    return null;
  }

  /**
   * Find the route from this node, to some ancestral node with id [descendentId]
   */
  public ArrayList<Node> getAncestorPathTo(long ancestorId) {
    ArrayList<Node> list = new ArrayList<Node>(), temp;
    list.add(this);
    if(id == ancestorId) {
      return list;
    }
    temp = parent.getAncestorPathTo(ancestorId);
    if(temp != null) {
      list.addAll(temp);
      return list;
    }
    return null;
  }

  public String toString() {
    return "{id:"+id+",label:"+label+"}";
  }
}