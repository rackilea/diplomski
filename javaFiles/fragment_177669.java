private List<String> findCommonElement2(String[] a, String[] b) {

    List<String> commonElements = new ArrayList<>();

    for(int i = 0; i < a.length; i++) {
        for(int x = 0; x < b.length; x++) {

            if(a[i].equals(b[x])) {
                commonElements.add(a[i]);
                b[x] = "ignore";
                break;
            }                               
        }

    }

    return commonElements;
}