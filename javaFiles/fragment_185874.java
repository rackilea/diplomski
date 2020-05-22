public T remove(T elt) {

    for (int i=0; i<data.length; ++i) {
        if (elt.equals(data[i]) ) {
            data[i] = null;
            for (++i; i < data.length; ++i) {
                data[i-1] = data[i];
            }
            break;
        }
    }