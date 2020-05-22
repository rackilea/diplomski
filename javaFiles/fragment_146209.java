List<ArrayList<String>> namesAndNumbers = new ArrayList<ArrayList<String>>();
namesAndNumbers.add(new ArrayList<String>(Arrays.asList("Mike", "(805) 766-4920")));
namesAndNumbers.add(new ArrayList<String>(Arrays.asList("Emily", "(705) 668-9292", "(705) 555-1060")));
namesAndNumbers.add(new ArrayList<String>(Arrays.asList("James", "(605) 965-2000")));
Collections.sort(namesAndNumbers, new Comparator<ArrayList<String>>() {    
        @Override
        public int compare(ArrayList<String> o1, ArrayList<String> o2) {
            return o1.get(0).compareTo(o2.get(0));
        }               
});
System.out.println(namesAndNumbers);