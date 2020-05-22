void createObj(MyObject objt)
{
    objt = new MyObject(); //Local Scope
}
//Caller
MyObject obj = null;
createObj(obj); // <-- New object will be created only within the function, obj will remain unaffected.
// obj is still null;