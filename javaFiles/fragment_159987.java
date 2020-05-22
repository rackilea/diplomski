@Entity
public class ProjectSequence {

    @EmbeddedId
    private ProjectSequenceId projectSequenceId;

    @ManyToOne
    @JoinColumn(name="ID", insertable=false, updatable=false)
    private Project project;

    @ManyToOne
    @JoinColumn(name="REFERENCE", referencedColumnName="REFERENCE", insertable=false, updatable=false)
    private Sequence sequence;

    public ProjectSequence() {}
    public ProjectSequence(ProjectSequenceId projectSequenceId) {
        this.projectSequenceId = projectSequenceId;
    }

    // getters and setters

    @Embeddable
    public static class ProjectSequenceId implements Serializable {

        @Column(name="ID", updatable=false)
        private Integer projectId;

        @Column(name="REFERENCE", updatable=false)
        private String reference;

        public ProjectSequenceId() {}
        public ProjectSequenceId(Integer projectId, String reference) {
            this.projectId = projectId;
            this.reference = reference;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof ProjectSequenceId))
                return false;

            final ProjectSequenceId other = (ProjectSequenceId) o;
            return new EqualsBuilder().append(getProjectId(), other.getProjectId())
                                      .append(getReference(), other.getReference())
                                      .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(getProjectId())
                                        .append(getReference())
                                        .hashCode();
        }

    }

}