class Triple{
private Integer value;
public Triple(Integer value){
 this.value = value;
}

public Integer getValue(){return this.value;}
public Integer getSquare(){return this.value*this.value;}
public Integer getOpposite(){return this.value*-1;}
public String toString() {return getValue()+", "+this.getSquare()+", "+this.getOpposite();}
}