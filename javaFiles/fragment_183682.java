List<Integer> lst; //the list of the integers
lst.removeAll(Collections.singleton(Collections.min(lst)));

Collections.sort(lst);

List<Container> containers = new ArrayList<>();
//filling the containers according to the requirements;