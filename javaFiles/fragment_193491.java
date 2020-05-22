int valueAtPosition(int k) {

    if(this.left!=null k >= 0){
        k = left.valueAtPosition(k);
    }

    if(k == 0){
        pos=this.elem;
    }
    k--;

    if(this.right!=null && k > 0){
        k = right.valueAtPosition();
    }

    return k;
}