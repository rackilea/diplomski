StringBuilder sb = new StringBuilder();
Iterator<Integer> iterator =
    Arrays.asList(1, 2, 3, 4, 5, 6, 7).iterator();
if(iterator.hasNext()){
    sb.append(iterator.next());
    while(iterator.hasNext()){
        sb.append(',').append(iterator.next());
    }
}
final String joined = sb.toString();