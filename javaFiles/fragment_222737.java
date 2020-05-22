class Pointer <T> {
  T target = null;
  Pointer(T target){
    this.target = target;
  }
  static Pointer nullPointer(){
    return new Pointer(null);
  }
  public void setTarget(T target){
    this.target = target;
  }
  public T getTarget(){
    return target;
  }
}