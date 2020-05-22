@Entity
@Table(name = "OPERATOR")
public class Operator {   
    @Id
    @Column(name = "ID")
    private Long id;
    ...

    @Column(name = "STATUS", columnDefinition = "VARCHAR(31)", nullable = false )
    @Type( type = "my.package.GenericEnumUserType",
           parameters = {
        @Parameter( name = "enumClass", value =  "my.package.Status" ),
        @Parameter( name = "identifierMethod", value = "toString" ),
        @Parameter( name = "valueOfMethod", value = "fromString" ) } )
    private Status status;
    ...
}