queue.add(this);

while (!queue.isEmpty())  
{  
    Node node = queue.remove();

    s += "" + node.getVal();

    if (node.left  != null) { queue.add(node.left);  }
    if (node.right != null) { queue.add(node.right); }
}