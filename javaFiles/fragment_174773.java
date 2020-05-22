try{
    tx =ses.beginTransaction();
    Posts p2 = new Posts();
    **p2 = (Posts)ses.get(Posts.class, p.getPostID());**
    p2.setPostID(p.getPostID());
    p2.setPostVote(p.getPostVote());
    p2.setOwnerID(p.getOwnerID());
//  ses.createQuery("UPDATE Posts SET PostVote="+p.getPostVote() +" WHERE PostID="+p.getPostID()+" AND OwnerID="+p.getOwnerID());
    ses.update(p2);
    tx.commit();    
}