import javax.validation.constraints.Null;

public class Contact {

    public interface Administrator {}

    public interface User {}

    ...

    public class Information {

        @Null(groups = User.class)
        public String securedField;

        ...

    }

}