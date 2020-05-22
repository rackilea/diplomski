private Kubus(T tinggi, T panjang,T lebar ) { ... }

public static Kubus<Integer> ofInteger(Integer tinggi, Integer panjang, Integer lebar ) {
  return new Kubus<>(tinggi, panjang, lebar);
}

public static Kubus<Long> ofLong(Long tinggi, Long panjang, Long lebar ) {
  return new Kubus<>(tinggi, panjang, lebar);
}

// etc for other specific types.