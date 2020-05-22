void foo (Node node){
  node.update()
}

bar(){
   foo (new Node())
   foo (new Derived())
}