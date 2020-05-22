if (key.compareTo(this.key) < 0) {
    if (this.left == null) {
        System.out.println(key + " : insert success");
        this.left = new BST(key);
        return true;
    } else {
        return insert(key);
    }