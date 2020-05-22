public void myMethod(){
    try {
        if (whatever){
             throw new CardException();
        }
        if (something else){
            throw new InvalidCardException();
        }
        if (scenario 3){
            throw new TwoCardsException();
        }
    }
    catch (CribbageException e) {
          System.out.println(e.getMessage());
    }
}