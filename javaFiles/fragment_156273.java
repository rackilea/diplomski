Criteria criteria = session.createCriteria(Book.class);
if (author != null && !author.isEmpty()) {
    criteria.add(Restriction.eq("author", author));
}
if (title != null && !title.isEmpty()) {
    criteria.add(Restriction.eq("title", title));
}
criteria.addOrder(Order.asc("publishDate"));
return (List<Book>) criteria.list();