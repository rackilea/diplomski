public static void main(String[] args) {
    List<A> list = Arrays.asList(new A("aa", "bb"), new A("aaC", "bb"));
    Test test = new Test();
    test.setList(list);
    test.createPred("aa", A::getB);
  }



  public static class Test {

    private List<A> list;

    public void setList(List<A> list) {
      this.list = list;
    }

    public <T> Predicate<A> createPred(T query, Function<A, T> f) {
      return new Predicate<A>() {
        @Override
        public boolean test(A x) {
          return f.apply(x).equals(query);
        }
      };
    }

    public List<A> search(Predicate<A> a) {
      return list.stream().filter(a).collect(Collectors.toList());
    }
  }