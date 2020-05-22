class Node(val data: Int) {
   var parents : ListBuffer[Node] =  ListBuffer[Node]()
   var children : ListBuffer[Node] =  ListBuffer[Node]()
}
scala> val node1 = new Node(1)
node1: Node = Node@624ea235

scala> val node2 = new Node(2)
node2: Node = Node@12591ac8

scala> node1.children.append(node2)

scala> node2.parents.append(node1)