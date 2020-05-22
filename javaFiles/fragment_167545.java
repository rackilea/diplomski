if (Objects.nonNull(comment)) {
      Article a = comment.getArticle();
      a.getComments().remove(comment);
      articleDao.saveOrUpdate(a);
      return true;
}