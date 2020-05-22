@GetMapping("/getNombre/{nom}")
private List<PersonaNegativa> getByNombre(@PathVariable String nom) {
    DoubleMetaphone dm = new DoubleMetaphone();
    dm.setMaxCodeLen(5);

    int parameterCount = 0;
    StringBuilder clause = new StringBuilder();
    List<String> parameters = new ArrayList<>();
    for (String string : nom.split(" ")) {
        clause.append((clause.length() == 0) ? " p.NombreCompletoFonetico like ?" : " or p.NombreCompletoFonetico like ?");
        parameters.add("%" + dm.doubleMetaphone(string));

    }

    String jpaql = "select p from PersonaNegativa p where " + clause.toString();

    List<PersonaNegativa> listneg = new ArrayList<PersonaNegativa>();
    try {
        TypedQuery<PersonaNegativa> query = entityManager
                .createQuery(jpaql,
                        PersonaNegativa.class);
        for (int i = 0; i < parameters.size(); i++) {
            query.setParameter(i, parameters.get(i))
        }
        return query.getResultList();

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}