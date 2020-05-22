@MappedSuperclass
    public abstract class PersistentEntity implements Serializable
    {
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_gen")
        protected Long id = 0L;

        public Long getId()
        {
            return id;
        }

        public void setId(Long id)
        { 
            this.id = id;
        }
    }