import static com.google.common.collect.Iterables.limit;
 import static com.google.common.collect.Iterables.skip;

 ...

 static <T> Iterable<T> bounded(Iterable<T> iterable, int startIndex, int lastIndex) {
     return limit(skip(iterable, startIndex+1), lastIndex-startIndex);
 }

 bounded(list, 2, 5)//[3, 4, 5]