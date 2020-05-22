List<Object> list = Arrays.asList(1,null, new Object(),4,5,6);
int expected = list.hashCode();

int hashCode = list.stream().collect(hashing());
if(hashCode != expected)
    throw new AssertionError();

// works in parallel
hashCode = list.parallelStream().collect(hashing());
if(hashCode != expected)
    throw new AssertionError();

// a method avoiding auto-boxing is more complicated:
int[] result=list.parallelStream().mapToInt(Objects::hashCode)
    .collect(() -> new int[2],
    (a,o)    -> { a[0]=a[0]*31+Objects.hashCode(o); a[1]++; },
    (a1, a2) -> { a1[0]=a1[0]*iPow(31,a2[1])+a2[0]; a1[1]+=a2[1]; });
hashCode = iPow(31,result[1])+result[0];

if(hashCode != expected)
    throw new AssertionError();

// random access lists allow a better solution:
hashCode = IntStream.range(0, list.size()).parallel()
    .map(ix -> Objects.hashCode(list.get(ix))*iPow(31, list.size()-ix-1))
    .sum() + iPow(31, list.size());

if(hashCode != expected)
    throw new AssertionError();