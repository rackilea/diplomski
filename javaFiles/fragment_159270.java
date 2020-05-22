List<User> result = Stream
    .concat(first.stream(), second.stream())
    .collect(Collectors.toMap(
         User::getName,
         u -> new User(u.getName(), u.getComments()),
         (l, r) -> {
              l.setComments(l.getComments() + r.getComments());
              return l;
         }))
    .values()
    .stream()
    .collect(Collectors.toList());