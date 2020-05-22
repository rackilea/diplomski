public Class Person {

   private String name;
   private List<CreditCard> creditCards;

   // toString, equals, constructor, etc.

   public void setCreditCards(List<CreditCard> creditCards) {
      this.creditCards = creditCards;
   }

   public List<Creditcard> getCreditCards() {
      return this.creditCards;
   }

   // more getters and setters