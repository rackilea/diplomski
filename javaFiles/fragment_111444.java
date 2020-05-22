@Entity
@IdClass(PermissionId.class)
public class Permission {

    private Integer field1;
    private Integer field2;
    private Integer field3;

    // required no-arg constructor   
    public Permission() {}

    public Permission(Integer field1, Integer field2, Integer field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    @Id
    @Column(name="FIELD_1", nullable=false)
    public Integer getField1() {
        return this.field1;
    }

    @Id
    @Column(name="FIELD_2", nullable=false)
    public Integer getField2() {
        return this.field2;
    }

    @Id
    @Column(name="FIELD_3", nullable=false)
    public Integer getField3() {
        return this.field3;
    }

    @Embeddable
    public static class PermissionId implements Serializable {

        private Integer field1;
        private Integer field2;
        private Integer field3;

        // required no-arg constructor
        public PermissionId() {}

        public PermissionId(Integer field1, Integer field2, Integer field3) {
            this.field1 = field1;
            this.field2 = field2;
            this.field3 = field3;
        }

        @Column(name="FIELD_1")
        public Integer getField1() {
            return this.field1;
        }

        @Column(name="FIELD_2")
        public Integer getField2() {
            return this.field2;
        }

        @Column(name="FIELD_3")
        public Integer getField3() {
            return this.field3;
        }

        public boolean equals(Object o) {
            if(o == null) 
                return false;

            if(!(o instanceof PermissionId))
                return false;

            final PermissionId other = (PermissionId) o;

            if(!(getField1().equals(other.getField1()))) 
                return false;

            if(!(getField2().equals(other.getField2()))) 
                return false;

            if(!(getField3().equals(other.getField3()))) 
                return false;

            return true;
        }

        // requered hashcode impl
        public int hashcode() {
            // code goes here     
        }

    }

}