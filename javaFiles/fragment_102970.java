// The below syntax is called `double braces initialization`.
List<List<Integer>> triangularNumber = new ArrayList<List<Integer>>() {
    {
        // Add inner lists to the outer list.
        add(Arrays.asList(4)); 
        add(Arrays.asList(5, 3));
        add(Arrays.asList(9, 2, 21));
        add(Arrays.asList(1, 46, 12, 8));
    }
};

int sum = 0;
for (List<Integer> innerList: triangularNumber) {
    sum += Collections.max(innerList);
}

System.out.println(sum);