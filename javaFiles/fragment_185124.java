public static void main(String a[]){
  //Other code omitted
  FileOutputStream fos = new FileOutputStream("c:\\yourfile",true); //true specifies append
  Foo f = new Foo(1, "booo", new Bar(42));
  xs.toXML(f,fos);
}