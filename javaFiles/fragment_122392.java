for(int i = 0; i< a.size();i++) {
        if (a.get(i).equals(e.value)) {
            a.remove(e.value);
            i--;
        }
    }