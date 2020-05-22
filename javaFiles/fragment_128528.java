MyClass x = null;
try{
    x = new MyClass();
    x.work();
} finally {
    if (x!=null)
        x.close();
}