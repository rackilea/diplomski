@Override
public int compare(A o1, A o2) {
    if (o1 == o2) {
        return 0;
    } else if (o1 == null) {
        return -1;
    } else if (o2 == null) {
        return 1;
    }
    if (o1.getId1() != o2.getId1()) {
        return o1.getId1() - o2.getId1();
    } else {
        return o1.getId2() - o2.getId2();
    }
}