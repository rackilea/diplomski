private boolean createdByFirst = false;
private boolean createdBySecond = false;

public Fraction(yourCode){
  createdByFirst = true;
}

public Fraction(yourOtherCode){
  createdBySecond = true;
}

public String toString(){
  if(createdByFirst)
    return "yourStringForFirstConstructor";
  else if(createdBySecond)
    return "yourStringForSecondConstructor";
  else
    return "Something else";
}