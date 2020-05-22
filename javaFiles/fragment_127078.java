String targetName = "Jane";
    Customer result = null;
    for (Customer c : list) {
        if (targetName.equals(c.getName())) {
            result = c;
            break;
        }
    }