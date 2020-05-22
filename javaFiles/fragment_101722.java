// tranformer
interface BinaryTransformer<X, Y, Z> {
  Z transform(X a, Y b);
}

// implementation for your problem
class ConcatTransformer implements BinaryTransformer<String, String, String> {
  public String transform(String a, String b) {
    return a + b;
  }
}

// general use transformer
class BinaryListUtils {
  public static <X, Y, Z> List<Z> collect(List<X> aList, List<Y> bList, BinaryTransformer<X, Y, Z> t) {
    List<Z> ret = new ArrayList<Z>(aList.size());
    Iterator<X> aIter = aList.iterator();
    Iterator<Y> bIter = bList.iterator();
    while(aIter.hasNext()) {
      ret.add(t.transform(aIter.next(), bIter.next()));
    }
  }
}