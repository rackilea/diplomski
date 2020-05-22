EnumMap<Color, Long> map = list.stream().collect(Collectors.toMap(
    Person::getFavouriteColor, x->1L, Long::sum, ()->{
        EnumMap<Color, Long> em = new EnumMap<>(Color.class);
        EnumSet.allOf(Color.class).forEach(c->em.put(c, 0L));
        return em;
    }));