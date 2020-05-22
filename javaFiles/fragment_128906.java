class A implements Cloneable{
    .....
    @Override
    public Object clone() throws CloneNotSupportedException{
      return super.clone();
    }
}