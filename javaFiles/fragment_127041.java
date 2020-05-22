public Boolean find(int x) {

    if (this.payload == x) {
        return true;
    } if (this.left != null && this.left.find(x)){
        return true;
    }if (this.right != null && this.right.find(x)) {
        return true;
    }
    return false;

}