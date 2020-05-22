package com.shi.tree;

public class Node {
private int key;
private String name;
private Node leftChild,rightChild;
public Node(int key, String name) {
    this.key = key;
    this.name=name;
    // TODO Auto-generated constructor stub

}
public int getKey() {
    return key;
}
public void setKey(int key) {
    this.key = key;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public Node getLeftChild() {
    return leftChild;
}
public void setLeftChild(Node leftChild) {
    this.leftChild = leftChild;
}
public Node getRightChild() {
    return rightChild;
}
public void setRightChild(Node rightChild) {
    this.rightChild = rightChild;
}
@Override
public String toString() {
System.out.println("key :"+this.getKey()+" Name :"+this.getName());
// TODO Auto-generated method stub
return super.toString();
}
}