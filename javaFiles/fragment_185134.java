public interface Friend {}

public class Man implements Friend {}

public class Dog implements Friend {}

public class FriendRelationship {
    private Friend first;
    private Friend second;

    public FriendRelationship(Friend first, Friend second) {
        this.first = first;
        this.second = second;
    }
}

Man aPerson = new Man();
Dog aBog = new Dog();
FriendRelationship bestFriends = new FriendRelationship(aPerson, aDog);