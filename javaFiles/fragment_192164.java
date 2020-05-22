public Integer halfOfB(Session hibernate, List<B> b) throws Exception {

    for (int i = 0; i < b.size(); i++) {
      B bb = b.get(i);
      List<A> aa = bb.getaList();
      if (repeat(bb, hibernate, b)) {
        return aa.size();
      } else {
        repeat(bb, hibernate, b);
      }

    }
    throw new Exception("error in halfOfB");
  }

  private boolean repeat(B bb, Session hibernate, List<B> b) throws Exception {
    List<A> aa = bb.getaList();
    if (aa.size() <= 5) {
      return true;
    } else {
      Integer br = (Integer) hibernate.createCriteria(B.class)
              .setProjection(Projections.max("number")).uniqueResult() + 1;
      B bbb = new B();
      bbb.setNumber(br);
      List<A> half = aa.subList(aa.size() / 2, aa.size());
      removeListOfAtoB(hibernate, half, bb);
      addListOfAtoB(hibernate, half, bb);
    }
    return false;
  }