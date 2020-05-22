try {
    if(count==0){
        callmethod();
    } else {
        throw new SomeException("some message");
    }
}
catch (Exception e){
    System.out.println(e);
}