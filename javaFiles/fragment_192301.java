@Entity
    @Table(name = "role")
    @SequenceGenerator(name = "default_gen", sequenceName = "role_seq", allocationSize = 1)
    public class Role extends PersistentEntity implements Serializable
    {
        private static final long serialVersionUID = 1L;

        @NotNull
        @Size(max = 32)
        private String name;

        public String getName()
        {
             return name;
        }

        public void setName(String name)
        {
             this.name = name;
        }   
    }