public void insert(int x) {
        if(x < this.info) {
            if(this.left == null)
                this.left = new NODE(x);
            else
                this.left.insert(x);
        }
        else {
            if(this.right == null)
                this.right = new NODE(x);
            else
                this.right.insert(x);
        }
    }