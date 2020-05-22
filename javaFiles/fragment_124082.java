public static void main(String[] args) {
    EpicCoolInterface<Integer> a = new EpicCoolInterface<Integer>() {
    };
    System.out.println(a.getParameterizedTypeClass());
    EpicCoolInterface<EpicCoolInterface<Integer>> b = new EpicCoolInterface<EpicCoolInterface<Integer>>() {
    };
    System.out.println(b.getParameterizedTypeClass());
    EpicCoolInterface<EpicCoolInterface<?>> c = new EpicCoolInterface<EpicCoolInterface<?>>() {
    };
    System.out.println(c.getParameterizedTypeClass());
  }