class A implements Decorator{    
    @Override
    public void decorate(){
      System.out.print("Decorate A");
    }

    @Override
    public void help(){
      System.out.print("Help");
    }

}

class B implements Decorator{    
    private Decorator member;

    public B(Decorator decorator){
      this.member = decorator;
    }

    @Override
    public void decorate(){
      member.decorate();
      System.out.print("Decorate B");
    }

    @Override 
    public void help(){
      //***you need the behaviour of A here
      member.help();
    }
}

Decorator d = new B(new A());
b.help();