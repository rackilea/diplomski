static final String DF = "DD/MM/YYYY";
static final SimpleDateFormat SDF = new SimpleDateFormat(DF);

@Override
public List<Program> getListProgram() {
    Session session=sessionFactory.openSession();
    Criteria criteria=session.createCriteria(Program.class);
    List<Program> =(List<Program>)criteria.list();
    boolean asc = true;
    programs.sort((a, b) -> {
        int comparison = 0;
        try {
            comparison = SDF.parse(a.getCreatedDate()).compareTo(SDF.parse(b.getCreatedDate()));
        } catch (ParseException e) {
            // handle it!!
        }
        return asc ? comparison : (0-comparison);
    });
    return programs;
}