public class DisjointFriendSet {
    private final Map<String, Set<String>> personToFriends = new HashMap<>();

    /**
     * Includes the person themselves in their group of friends.
     * 
     * If no friendships have been registered for this person, then returns a set
     * containing just themselves.
     * 
     * @param person
     * @return
     */
    public Set<String> getFriends(String person) {
        if(personToFriends.containsKey(person)) {
            return personToFriends.get(person);
        } else {
            final Set<String> result = new HashSet<>();
            result.add(person);
            return result;
        }
    }

    public void addFriendship(String person1, String person2) {
        final Set<String> friends1 = getFriends(person1);
        final Set<String> friends2 = getFriends(person2);

        if(friends1 == friends2) {
            return;
        } else {
            personToFriends.put(person1, friends1);
            friends1.addAll(friends2);
            for(String person: friends2) {
                personToFriends.put(person, friends1);
            }
        }
    }

    /**
     * 
     * @return All unique friendship groups
     */
    public Collection<Set<String>> getAllFriendshipGroups() {
        return new HashSet<>(personToFriends.values());
    }

    public static void main(String[] args) {
        final DisjointFriendSet disjointFriendSet = new DisjointFriendSet();

        disjointFriendSet.addFriendship("Alice","Beowulf");
        disjointFriendSet.addFriendship("Charity","Donald");
        disjointFriendSet.addFriendship("Eduardo","Frank");
        disjointFriendSet.addFriendship("Grendel","Harriet");

        System.out.println("Friendship groups: "+disjointFriendSet.getAllFriendshipGroups());

        System.out.println("Adding friendship between Grendel and Beowulf");
        disjointFriendSet.addFriendship("Grendel","Beowulf");
        System.out.println("Friendship groups: "+disjointFriendSet.getAllFriendshipGroups());
        System.out.println();

        for(String person: new String[]{"Alice","Beowulf","Charity","Donald","Eduardo","Frank","Grendel","Harriet","Zod"}) {
            System.out.println(person+"'s friends: "+disjointFriendSet.getFriends(person));
        }
    }
}