Base[] arr = new Base[3];
arr[0] = new Base();
arr[1] = new Derived1();
arr[2] = new Derived2();
for(Base b : arr){
    b.method();
}