public class QuoteId implements Serializable {
    private int id1;
    private int id2;

    public QuoteId() {}

    //This equals does not matter when we build LinkedHashSet
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuoteId other = (QuoteId) o;
        return id1 == other.id1 && id2 == other.id2;
    }

    public int hashCode() {
        return 31 * id1 + id2;
    }
}

@Entity
@IdClass(QuoteId.class)
public class Quote {
    @Id private int id1;
    @Id private int id2;
    String value;

    public Quote() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote other = (Quote) o;
        return id1 == other.id1 && id2 == other.id2;
    }

    @Override
    public int hashCode() { return 31 * id1 + id2;}

    //get&set for id1, id2, and value are omitted
}


tx.begin();
em.persist(new Quote(1, 1, "val"));
em.persist(new Quote(1, 2, "val"));
tx.commit();

TypedQuery<Quote> query = em.createQuery("SELECT q FROM Quote q", Quote.class);
List<Quote> twoQuotes = query.getResultList();//both

//duplicating (size=4) result for sake of test;
List<Quote> fullQuoteResults = new ArrayList<Quote>();
fullQuoteResults.addAll(twoQuotes);
fullQuoteResults.addAll(twoQuotes);

//will have same elements as in twoQuotes:
List<Quote> uniqueQuoteResults = new ArrayList<Quote>(
        new LinkedHashSet<Quote>(fullQuoteResults));