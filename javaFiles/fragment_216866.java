public void adjustQuantity(int adjustingQuantity) { 
    int iNewQuantity = this.quantity + adjustingQuantity;
    if (iNewQuantity >= 0)
        this.quantity = iNewQuantity 
    else
        this.quantity = 0;
}