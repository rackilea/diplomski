try(Animal a1 = new Animal();){
    foo();
}
catch(Exception e){
    System.err.println(e);
    for(Throwable t : e.getSuppressed()){
        System.err.println("suppressed "+ t);
    }
}