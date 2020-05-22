%rename(Standard_Type) Handle_Standard_Type;
%typemap(javacode) Handle_Standard_Type %{  
  public boolean equals(Object obj) {
    boolean equal = false;
    if (obj instanceof $javaclassname)
      equal = ((($javaclassname)obj).swigCPtr == this.swigCPtr);
    return equal;
    }
%} 
class Handle_Standard_Type {};