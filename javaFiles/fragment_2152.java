@ManyToMany(fetch = FetchType.LAZY,
        cascade =
        {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST
        },
        targetEntity = Course.class)
@JoinTable(name = "XTB_STUDENTS_COURSES",
        inverseJoinColumns = @JoinColumn(name = "COURSE_ID",
                nullable = false,
                updatable = false),
        joinColumns = @JoinColumn(name = "STUDENT_ID",
                nullable = false,
                updatable = false),
        foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
        inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
private final Set<Course> courses = new HashSet<>();

@ManyToMany(fetch = FetchType.LAZY,
        cascade =
        {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST
        },
        targetEntity = Student.class)
@JoinTable(name = "XTB_STUDENTS_COURSES",
        joinColumns = @JoinColumn(name = "COURSE_ID",
                nullable = false,
                updatable = false),
        inverseJoinColumns = @JoinColumn(name = "STUDENT_ID",
                nullable = false,
                updatable = false),
        foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
        inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
private final Set<Student> students = new HashSet<>();