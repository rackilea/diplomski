public String bar;

public B(){
    this("Base: ");
}

protected B(String source){ //protected to prevent anybody to use it directly
    bar = source + foo();
}