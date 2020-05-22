QueryBuilder query = QueryBuilders.boolQuery()
   .must(QueryBuilders.queryStringQuery("ABC1234"))
   .filter(QueryBuilders.termsQuery("ticket.inquiryType", "INQTYP01", "INQTYP06"))
   .filter(QueryBuilders.termsQuery("ticket.status", "NEW", "CLOSED"))
   .filter(QueryBuilders.termsQuery("ticket.ownership", "OWNED", "OTHER_OWNER"));
ticketInfoSourceBuilder.query(query);