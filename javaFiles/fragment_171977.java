@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Member {
    // common fields
}

@Entity
public class OAuth2Member extends Member {
    // fields
}

@Entity
public class GeneralMember extends Member {
    // fields
}