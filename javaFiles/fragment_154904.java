public int BSTsmallcount(BinNode root, int key)
{
    int count = 0;

    if (root == null) {
        return 0;
    }
    else if (root.value() < key) {
        count++;
        count += BSTsmallcount(root.left(), key);
        count += BSTsmallcount(root.right(), key);
    }
    else {
        count += BSTsmallcount(root.left(), key);
    }

    return count;
}