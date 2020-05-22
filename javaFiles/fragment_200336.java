AnonymousClasses jonny = new AnonymousClasses(new GreetingModule(){
    @Override
    public void sayHello() {
        System.out.println("Hey");
    }
}) {
      // Overriding anything here is optional
};