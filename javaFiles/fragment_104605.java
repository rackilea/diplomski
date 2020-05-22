public interface Member {
}

public class Person implements Member {
    private int id; // primary key
    private String name;
}

public class Family implements Member {
   private int id;
   private String name;
}

public class Club {
    private String name; // primary key
}

public class Membership {
   private Member member;
   private Club club;
   private Date expires;
}