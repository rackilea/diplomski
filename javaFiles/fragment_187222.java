// assuming query like
// select oComment from comment inner join Note on comment.noteuuid=Note.noteuuid where Note.noteUuid = 1 and version > 0;

CriteriaBuilder cb = em.getCriteriaBuilder();
// data type of oComment
CriteriaQuery<Note> query = cb.createQuery(Note.class);
// from comment
Root<Comment> comment = query.from(Comment.class);

//join
Join<Comment, Note> note = comment.join(comment.get("oNote"));

//version Condition
Predicate version=cb.greaterThan(comment.get("version"),0 );

//Note condition
predicate note=cb.equal(note.get("noteuuid"),note.getNoteUuid());

// get oComment and where condtion 
query.select(comment.get("oComment")).where(cb.and(version,note));

    return  em.createQuery(query).setFirstResult(iOffset).setMaxResults(iResultSize).getResultList();