String[] strArr = {"anc", "asda"};
Object[] objArr = {strArr, strArr}; // Array of String Arrays
for (Object obj : objArr) {
    if (obj instanceof String[]) {
        String[] strArray = (String[]) obj;
        System.out.println(Arrays.toString(strArray));
        // System.out.println(obj);
    }
}