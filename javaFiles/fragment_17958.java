private void take(String item) {
    if (current.contains(item) == true) {
        current.removeItem(item); // can't get this to work
        inventory.add(item);
        System.out.println("You picked up the " + item + "and stashed it away");
    } else {
        System.out.println("Unknown object '" + item + "'.");
    }
}

private void drop(String item) {
    if (current.contains(item) == true) {
        inventory.remove(item);
        current.addItem(item); // or this
        System.out.println("You dropped the " + item + "and left it in the " + current);
    } else {
        System.out.println("Unknown object '" + item + "'.");
    }
}