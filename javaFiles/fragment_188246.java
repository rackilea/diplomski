public boolean equals(Object obj) {
        if (obj instanceof Integer) { //<<<---- instance of checking
            return value == ((Integer)obj).intValue();
        }
        return false;
    }