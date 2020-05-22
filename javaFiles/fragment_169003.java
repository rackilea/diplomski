Map<Integer, Integer> hash = new HashMap<>();

for (int i = 0; i < n; i++) {
    arr[i] = sc.nextInt();
    if (!hash.containsKey(arr[i])) {
        hash.put(arr[i], 0)
    }
    hash.put(arr[i], hash.get(arr[i]) + 1);
}

int count = 0;

for (int i = 0; i < n; i++) {
    if (hash.containsKey(arr[i]^x)) {
        count += hash.get(arr[i]^x);
    }
}