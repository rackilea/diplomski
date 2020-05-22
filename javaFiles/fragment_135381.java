public String decrypt () {

    if (this.right == null) {
       return this.letter;
    }
    if (this.left == null) {
        return this.letter + this.right.decrypt();
    }
    return this.left.decrypt() + this.letter + this.right.decrypt();
}