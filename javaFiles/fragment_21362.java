@Entity
class Container {

// How do I map multiple @OneToOne relationships to the uncertainty table based on e.g. the value of data_field = 'propertyA' or data_field = 'propertyB'

    @OneToOne
    private Uncertainty propertyA;
    @OneToOne
    private Uncertainty propertyB;
}