String targetName = "Jane";
    List<Customer> list = new ArrayList<Customer>();
    Iterator<Customer> iter = list.iterator();
    while (iter.hasNext()) {
        Customer c = iter.next();
        if (targetName.equals(c.getName())) {
            iter.remove();
            break;
        }
    }