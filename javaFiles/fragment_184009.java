@Id 
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;

@OneToOne(cascade = {CascadeType.ALL})
@PrimaryKeyJoinColumn
private ClassB classB;

public setClassB(ClassB classB) {
    this.classB = classB;
    this.classB.setClassA(this);
}