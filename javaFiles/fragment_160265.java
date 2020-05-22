@Entity
public Class MyEntity implements Serializable {
    @Id
    private Long id;

    @Column
    private String clazz;

    public Class getClazz () {
        return this.clazz != null ? Class.forName(this.clazz) : null; 
    }

    public Class setClazz (Class clazz) {
        this.clazz = clazz.getName();
    }
}