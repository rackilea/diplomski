// in TestB
void boo(TestA someInstance){
   this.y = someInstance.y; 
   // does not compile, because someInstance.y is not visible
   // because it could be from unknown TestC
}