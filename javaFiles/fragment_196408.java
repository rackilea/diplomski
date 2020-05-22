// default constructor
public GoBoard(){
    this(9);  // calls other constructor
}

public GoBoard(int pLinien){
    this.linien = pLinien;
    this.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
}