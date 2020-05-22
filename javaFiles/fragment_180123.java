private Map<Long, Long> map = new HashMap<Long, Long>();

public long syraLength(long n) {

    if (!map.containsKey(n)) {
        if (n == 1)
            map.put(n, 1L);
        else if (n % 2 == 0)
            map.put(n, n + syraLength(n/2));
        else
            map.put(n, n + syraLength(3*n+1));
    }

    return map.get(n);

}