String args[] = {"this is id", "this is name"};

Arrays.asList(Book.class.getConstructors()).stream()
    .filter(c -> c.getParameterCount() == args.length).forEach(c -> {
      if (IntStream.range(0, c.getParameterCount()).allMatch(i -> {
        return Arrays.asList(c.getParameterTypes()[i].getDeclaredMethods()).stream()
            .filter(m -> m.getName().equals("valueOf")).anyMatch(m -> {
              try {
                m.invoke(null, args[i]);
                return true;
              } catch (Exception e) {
                return false;
              }
            });
      }))
        System.out.println("Matching Constructor: " + c);
    });