public static void main(String args[]){
        DeckOfCards kerds = new DeckOfCards();
        kerds.setVal("A");
        kerds.setTyp("TYPE_A");

        System.out.println("Displaying values of kerds");
        System.out.println("kerds value : " + kerds.getVal());
        System.out.println("kerds type : " + kerds.getTyp());
        }