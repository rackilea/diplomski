@Entity
public class Something
{
    ...

    @OneToMany(cascade = ALL, orphanRemoval = true)
    @JoinColumn(name = "SOMETHING_ID")
    private Set<Value<?>> values = new LinkedHashSet<>();

    ...
}