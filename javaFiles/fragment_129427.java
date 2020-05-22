Node rightmost = root != null ? root.lchild : null;
if (rightmost != null)
    while (rightmost.right != null) {
       rightmost = rightmost.right;
    }
}

if (rightmost != null) { // root or root.lchild is null
    // found
}