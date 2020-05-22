public void addBid(String itemName, String nameOfBidder, double price) {
    if (itemName == null || nameOfBidder == null) {
        throw new NullPointerException("Name of the bidder cannot be null");
    }
    if (itemName.equals("") || nameOfBidder.equals("") || price <= 0) {
        throw new IllegalArgumentException("Name of the bidder cannot be empty");
    }
    Optional<Person> person = bidders.stream().filter(e -> e.getName().equals(nameOfBidder)).findAny();
    Optional<Item> item = items.stream().filter(e -> e.getName().equals(itemName)).findAny();
    if (person.isPresent()) {
        checkItemAndAddBid(item, person.get(), price);
    } else {
        Person newPerson = new Person(nameOfBidder);
        bidders.add(newPerson);
        System.out.println("Creating a new bidder: "+newPerson.getName());
        checkItemAndAddBid(item, newPerson, price);
    }
}

public void checkItemAndAddBid(Optional<Item> item, Person person, double price) {
    if (!item.isPresent()) {
        throw new NoSuchElementException("There is no such Item in the Auction");
    } else {
        item.get().addBid(person, price);
    }
}