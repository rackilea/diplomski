public Class loadClass(String name) throws ClassNotFoundException {
    if(name.equals("javax.lang.ClassIDontLike")){
       throw new ClassNotFoundException("I'm sorry, Dave. I'm afraid I can't do that.");
    }
    return super.loadClass(name, false);
}