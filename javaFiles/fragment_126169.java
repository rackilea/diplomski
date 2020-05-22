private Kubus(T tinggi, T panjang,T lebar, ToLongFunction<T> converter ) { ... }

public static Kubus<Integer> ofInteger(Integer tinggi, Integer panjang, Integer lebar ) {
  return new Kubus<>(tinggi, panjang, lebar, i -> i.intValue());
}

public static Kubus<Long> ofLong(Long tinggi, Long panjang, Long lebar ) {
  return new Kubus<>(tinggi, panjang, lebar, lng -> lng.longValue());
}

// etc for other specific types.