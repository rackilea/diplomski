values.stream()
   .collect(Collector.of(
      ArrayList::new,
      (List<List<SomeObject>> best, List<SomeObject> elem) -> {
        if (best.isEmpty()) {
          best.add(elem);
        } else if (best.get(0).size() < elem.size()) {
          best.clear();
          best.add(elem);
        }
      },
      (best1, best2) -> {
        if (best1.isEmpty() || best2.isEmpty()
              || best1.get(0).size() == best2.get(0).size()) {
          best1.addAll(best2);
          return best1;
        } else if (best1.get(0).size() > best2.get(0).size()) {
          return best1;
        } else {
          return base2;
        }
      }));