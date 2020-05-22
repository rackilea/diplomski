class B<T extends A>
{
  List<T> myGenericList;

  B(List<T> myGenericList){
    this.myGenericList = myGenericList;
  }

  public List<T> getMyGenericList(){
    return myGenericList;
  }
}