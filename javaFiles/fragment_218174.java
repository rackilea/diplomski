String[] values = {
  CLetters.get(Randal.nextInt(CLetters.size())),
  Letters.get(Randal.nextInt(Letters.size())),
  Numbers.get(Randal.nextInt(Numbers.size()))
};

String CLLN = values[new Random().nextInt(values.length)];