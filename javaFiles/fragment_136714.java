import lombok.Data;

    @Entity
    @Data
    public class Todo {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String star;
        private String desc;
    }