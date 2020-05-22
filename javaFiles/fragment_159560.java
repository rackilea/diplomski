Iterator<CartEntry> it = list.iterator();
    while (it.hasNext()) {
        if (it.next().getpId() == pId) {
            it.remove();
            break;
        }
    }