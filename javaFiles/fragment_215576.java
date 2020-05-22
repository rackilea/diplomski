List<Comment> comments = (List<Comment>) session.createSQLQuery(
        "select * " +
        "from Comment " +
        "where id in (   " +
        "    select comment_id " +
        "    from (     " +
        "        select        " +
        "            c.id as comment_id,        " +
        "            SUM(CASE WHEN v.up=1 THEN 1 ELSE -1 END) AS vote_count     " +
        "        from Comment c     " +
        "        left join Votes v on c.id = v.comment_id     " +
        "        group by comment_id     " +
        "        order by vote_count desc   " +
        "    ) c_v " +
        ") c_id"
).addEntity(Comment.class).list();