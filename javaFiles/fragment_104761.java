enum TisztításiEljárás  {
    BIO_TISZTÍTÁS(new Időtartam(3, 20));

    private Időtartam javasoltVállalás;

    private TisztításiEljárás(Időtartam i) {
        javasoltVállalás = i;
    }

    public Időtartam getObj() {    // ordinary get method
        return javasoltVállalás;
    }
}