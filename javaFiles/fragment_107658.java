Criteria criteria = session.createCriteria(Book.class)
         // JOINs shelf association and creates alias 'shelf' for it
         .createAlias("shelf", "shelf")
         .add(Restrictions.eq("shelf.shelfId", bookLocId))
         .add(Restrictions.ne("shelf.shelfType", "table"))
         .add(Restrictions.ne("bookState", "requested");