public CalculatorAB implements ICalculator<CalculableObject> {
  void calculate(CalculableObject obj){
    if(obj instanceof TypeA)
      calculate((TypeA)obj);
    else if(obj instanceof TypeB)
      calculate((TypeB)obj);
  }
  void calculate(TypeA obj){...}
  void calculate(TypeB obj){...}
}