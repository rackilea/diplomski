public class Bid {
int ID;
String description;
Object bidStuff;

// ...as before

public Bid(Bid bid) {
    this.ID = bid.ID;
    this.description = bid.description;
    this.bidStuff = bid.bidStuff;
}

public static void main(String[] args) {
    List<Bid> original = new ArrayList<>();
    // ..populate it
    List<Bid> copy = new ArrayList<>(original.size());

    for (Bid b : original) {
        copy.add(new Bid(b));
    }
}
}