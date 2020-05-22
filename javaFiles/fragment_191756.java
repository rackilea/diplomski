@Override
public List<Quotation> search(String ticketNumber, String description, LocalDateTime startDate, LocalDateTime endDate) {
    System.out.println("Searching");
    JPQLQuery query = new JPAQuery(em);
    QQuotation quotation = QQuotation.quotation;
    return query.from(quotation).where(quotation.ticketNumber.like("this")).fetch();
}