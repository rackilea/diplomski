@Entity
@DiscriminatorValue(value = "1")
public class ConfirmedFriendship extends Friendship {

}

@Entity
@DiscriminatorValue(value = "0")
public class UnconfirmedFriendship extends Friendship {

}