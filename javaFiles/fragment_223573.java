HazardSubmission hs = (HazardSubmission)s.load(HazardSubmission.class, id);

System.out.println(Hibernate.getClass(hs).toString());
for (Field field : Hibernate.getClass(hs).getDeclaredFields()) {
    System.out.println(field .toString());
}