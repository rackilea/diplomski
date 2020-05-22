@Entity
class SomeEntity {

    @Column(name = "my_id_column_name")
    @Convert(converter = MyIDConverter.class)
    private ID itsID;
}