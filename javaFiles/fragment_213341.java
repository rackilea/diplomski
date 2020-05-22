find.where()
  .ilike("name", "%" + filter + "%")
  .orderBy("1;DROP TABLE company")
  .fetch("company")
  .findPagingList(pageSize)
  .setFetchAhead(false)
  .getPage(page);