public Comparable removeMin() {
  Iterator<T> it = iterator();
    T min;
    T next;


    if (it.hasNext()){
        min = it.next();
    } else {
        min = null;
    }


    while (it.hasNext()) {
        next = it.next();
        if (min.compareTo(next) > 0) {
        min = next;
        }
    }

    for (int i=0; i<size; i++) {
    if (data[i] == min) {
        data[i] = null;

        for (int j = i+1; j < data.length; j++) {
            data[j-1] = data[j];
        }

      }

    }

    size--;
    return min;

}