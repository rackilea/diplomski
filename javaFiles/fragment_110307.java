Iterator<Comment> commentIter = relevant.iterator();
Iterator<GitItem> itemIter = tree.iterator();
while (commentIter.hasNext() && itemIter.hasNext()) {
    Comment mc = commentIter.next();
    GitItem gi = itemIter.next();

    bb.buildBody(gi.getHash(), mc.getBody());
    MutableComment mutable = commentManager.getMutableComment(mc.getId());
    mutable.setBody(bb.sb.toString());
    commentManager.update(mutable, true);
}