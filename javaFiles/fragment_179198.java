public class MyFriends {

    private MyFriendsId myFrinedId;

    private FbUser me;
    private FbUser myFriend;

    public static class MyFriendsId implements Serializable {

        private Integer meId;
        private Integer myFriendId;

        // getter's and setter's

        public MyFriendsId() {}
        public MyFriendsId(Integer meId, Integer myFriendId) {
            this.meId = meId;
            this.myFriendId = myFriendId;
        }

        // getter's and setter's

        public boolean equals(Object o) {
            if(!(o instanceof MyFriendsId))
                return false;

            MyFriendsId other = (MyFriendsId) o;
            return new EqualsBuilder()
                       .append(getMeId(), other.getMeId())
                       .append(getMyFriendId(), other.getMyFriendId())
                       .isEquals();
        }

        public int hashcode() {
            return new HashCodeBuilder()
                       .append(getMeId())
                       .append(getMyFriendId())
                       .hashCode();
        }
    }
}