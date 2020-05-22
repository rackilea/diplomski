CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<CalendarEvent> criteria = builder.createQuery(CalendarEvent.class);
Root<CalendarEvent> root = criteria.from(CalendarEvent.class);

List<MailingCode> mailingCodes = Arrays.asList(
    new MailingCode(1),
    new MailingCode(2),
    new MailingCode(3)
);

Expression<List<Integer>> mailingCodesPath = root.get("mailingCodes");

Predicate predicate = builder.conjunction();

for(MailingCode mailingCode: mailingCodes){
    predicate = builder.and(predicate, builder.isMember(mailingCode.getId(), mailingCodesPath));
}

criteria.where(predicate);
List<CalendarEvent> events = entityManager.createQuery(criteria).getResultList();