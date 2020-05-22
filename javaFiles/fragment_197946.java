public enum MyEnum {

 ENUM1(new TransformerImpl1()),
 ENUM2(new TransformerImpl2()),
 ENUM3(new TransformerImpl3()),
 ENUM4(new TransformerImpl4());

 ITransformer myTransformer;
 MyEnum(ITransformer myTransformer){
      this.myTransformer=myTransformer;
 }
 public ITransformer getTransformer() {
       return this.myTransformer;
 }
}