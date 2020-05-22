@Entity
@DiscriminatorValue("1")
@SecondaryTable(name = "BAR", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "FOO_ID", referencedColumnName = "FOO_ID") })
public class Bar extends Foo {
    @OneToOne
    @JoinColumn(table = "BAR", name = "BAR_ID")
    MiniBar miniBar;
}