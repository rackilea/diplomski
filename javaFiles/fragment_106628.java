@Entity
public class MyEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(updatable = true)
    @Enumerated(EnumType.STRING)
    private ExamType examType;

    ...
}