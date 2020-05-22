if((this.row >= row1 && this.row <= row2 ||
    this.row <= row1 && this.row >= row2)
         && 
    (this.column >= column1 && this.column <= column2 || 
     this.column <= column1 && this.column >= column2))
{ 
    System.out.println("True" + "\n");
    return true;
}