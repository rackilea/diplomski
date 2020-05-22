@Entity
    public interface Y {

        void setId(Long id);

        @Id
        Long getId();
    }

   // introduce intermediate abstract class which implements Y

    @Entity
    public abstract class X implements Y {

    }

    // make Z extends X

    @Entity
    public class Z  extends X {

        // use targetEntity = X.class where required
        // leaving this class still free to use interface Y

        long id;

        @Override
        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public Long getId() {
            return id;
        }
    }