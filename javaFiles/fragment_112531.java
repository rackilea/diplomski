Collections.sort(list, new Comparator<String>() {

    @Override
    public int compare(String o1, String o2) {

        return o2.substring(o2.lastIndexOf(",")+1).compareTo(o1.substring(o1.lastIndexOf(",")+1));
    }
});
 System.out.println(list); //[Zimbabwe,82.2443, India,56.2355, Bahamas,32.2233, Australia,24.4363]