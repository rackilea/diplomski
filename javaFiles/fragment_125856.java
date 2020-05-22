private static int inorder(Node temp, int[] a, int i) {
// base case
if (temp == null) return i;

// go to the right of tree
i = inorder(temp.right, a, i);


// copy node to array
a[i] = temp.number;
System.out.println(temp.number);
System.out.println(i);
i++;

// go to the left of tree
i = inorder(temp.left, a, i);
return i;
}