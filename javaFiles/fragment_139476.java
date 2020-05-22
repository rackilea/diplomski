public BinTree root() {

 if (this.parent == null)
     return this;

 else
     return this.root();
    /// return parent;

     }