for (int i = 0; i < list.length - 1; i++) {
        if (list[i].compareTo(list[i + 1]) > 0) {
            return false;
        }
    }
    return true;