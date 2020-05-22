public Customer searchByName(List<Customer> list, String name) {
    for (int i = 0; i < list.size(); i++) {
        if ( list.get(i).name.equals(name) ) {
            return list.get(i);
        }
    }
    return null;
}