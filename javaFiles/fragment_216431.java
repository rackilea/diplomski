package com.shi.tree;

import java.io.*;
import java.util.*;
import com.shi.tree.Node;
public class BinaryTree {

public static int choice,listLength;



Node root;

public void addNode(int key, String name) {



Node newNode = new Node(key, name);



if (root == null) {

    root = newNode;

} else {




    Node focusNode = root;



    Node parent;

    while (true) {




        parent = focusNode;




        if (key < focusNode.getKey()) {



            focusNode = focusNode.getLeftChild();



            if (focusNode == null) {


                parent.setLeftChild(newNode);
                return;
            }

        } else {

            focusNode = focusNode.getRightChild();


            if (focusNode == null) {



                parent.setRightChild(newNode);
                return;

            }

        }

    }
}

}



public void inOrderTraverseTree(Node focusNode) {

if (focusNode != null) {



    inOrderTraverseTree(focusNode.getLeftChild());



    System.out.println(focusNode.toString());



    inOrderTraverseTree(focusNode.getRightChild());

}

}

public void preorderTraverseTree(Node focusNode) {

if (focusNode != null) {

    System.out.println(focusNode);

    preorderTraverseTree(focusNode.getLeftChild());
    preorderTraverseTree(focusNode.getRightChild());

}

}

public void postOrderTraverseTree(Node focusNode) {

if (focusNode != null) {

    postOrderTraverseTree(focusNode.getLeftChild());
    postOrderTraverseTree(focusNode.getRightChild());

    System.out.println(focusNode);

}

}

public Node findNode(int key) {



Node focusNode = root;



while (focusNode.getKey() != key) {



    if (key < focusNode.getKey()) {



        focusNode = focusNode.getLeftChild();

    } else {



        focusNode = focusNode.getRightChild();

    }



    if (focusNode == null)
        return null;

}

return focusNode;

}

 public static void main(String[] args)throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String x;
int y;

BinaryTree theTree = new BinaryTree();





 theTree.inOrderTraverseTree(theTree.root);









do
{
    try
        {
System.out.println("Choose: ");
System.out.println("[1]Insert ");
System.out.println("[2]Delete ");
System.out.println("[3]Display ");
System.out.println("[4]Search");
System.out.println("[5]Exit");
System.out.println("====================");
choice = Integer.parseInt(br.readLine());
switch(choice)
{
case 1 :    System.out.println("INSERT");
            System.out.println("Enter a key: ");
            y = Integer.parseInt(br.readLine());


            System.out.println("Enter a name: ");
            x = br.readLine();
            theTree.addNode(y,x);
            System.out.println("Tree: " + theTree.findNode(y));
            break;

case 2 :    System.out.println("DELETE");
            System.out.println("Enter the node to remove: ");
            x = br.readLine();

case 3 :    System.out.println("DISPLAY");

            System.out.println("In Order");
            theTree.inOrderTraverseTree(theTree.root);
            System.out.println("");

            System.out.println("PreOrder");
            theTree.preorderTraverseTree(theTree.root);
            System.out.println("");

            System.out.println("PostOrder");
            theTree.postOrderTraverseTree(theTree.root);
            System.out.println("");




case 4 :    System.out.println("SEARCH");
            System.out.println("Enter a key to find: ");
            int z = Integer.parseInt(br.readLine());
            //for(int i = 0; i<listLength;i++)
            //{

                if(theTree.findNode(z)!= null){

System.out.println("Found it! : " +     theTree.findNode(z) );

                }
                else{

                      System.out.println("ERROR: Not found!");

                }
                    break;




case 5 :    System.out.println("Bye");
            break;

  default : System.out.println("Try Again");
            break;
}
    }catch(NumberFormatException e)
    {
        System.out.println("Try again");
    }

}while(choice != 5);
}
}