Publication pub = ...;
Conference confToBeRemoved = ...;
Conference confToBeAdded = ...;

pub.getConferences().remove(confToBeRemoved); // this implies equals() and hashcode() are properly implemented
confToBeRemoved.getPublications().remove(pub); // same here

pub.getConferences().add(confToBeAdded);
confToBeAdded.getPublications().add(pub);

// save all