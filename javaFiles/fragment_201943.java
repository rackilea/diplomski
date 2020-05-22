/**
  * When both entity class and target table SHARE the same name
  * You do not need @Table annotation
  */
@Entity
public class SubPart implements Serializable {

    @EmbeddedId
    private SubPartId subPartId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PART_ID", insertable=false, updateable=false)
    private Part part;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="SUP_PART_ID", insertable=false, updateable=false)
    private SubPart subPart;

    /**
      * required no-arg constructor
      */
    public SubPart() {}
    public SubPart(SubPartId subPartId) {
        this.subPartId = subPartId;
    }

    // getter's and setter's

    /**
      * It MUST implements Serializable
      * It MUST overrides equals and hashCode method
      * It MUST has a no-arg constructor
      *
      * Hibernate/JPA 1.0 does not support automatic generation of compound primary key
      * You SHOULD set up manually
      */
    @Embeddable
    public static class SubPartId implements Serializable {

        @Column(name="PART_ID", updateable=false, nullable=false)
        private Integer partId;
        @Column(name="SUB_PART_ID", updateable=false, nullable=false)
        private Integer subPartId;

        /**
          * required no-arg constructor
          */
        public SubPartId() {}
        public SubPartId(Integer partId, Integer subPartId) {
            this.partId = partId;
            this.subPartId = subPartId;
        }

        // getter's and setter's

        @Override
        public boolean equals(Object o) {
            if(!(o instanceof SubPartId))
                return null;

            final SubPartId other = (SubPartId) o;
            return new EqualsBuilder().append(getPartId(), other.getPartId())
                                      .append(getSubPartId(), other.getSubPartId())
                                      .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(getPartId())
                                        .append(getSubPartId())
                                        .toHashCode();  
        }

    }

}