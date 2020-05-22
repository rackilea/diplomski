private Set<Teacher> teacher;

// Constructor with only one teacher.

public DespachoImpl(String nombre, Integer planta, Integer aforo, Teacher teacher) {
    super(TipoLugar.OTRO, nombre, planta, aforo);
    this.teacher = new HashSet<Teacher>();
    this.teacher.add( teacher );
}

// Constructor with a set of teachers.

public DespachoImpl(String nombre, Integer planta, Integer aforo, Set<Teacher> teachers) {
    super(TipoLugar.OTRO, nombre, planta, aforo);
    this.teacher = new HashSet<Teacher>(teachers);
}