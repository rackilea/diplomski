public void Func0(String sString1,int iInteger0,String sString2) {
  Object[] OrigArgs = func_get_args(sString1,iInteger0,sString2);//The arguments
  Func1(OrigArgs,1);
}
public void Func1(Object[] OriginalArgs,int AddedArg) {
  int NumFirstArgs = OriginalArgs.length;
  if (NumFirstArgs>3) {
    System.out.println("you have more than 3 arguments originally");
  }
}