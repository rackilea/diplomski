for (Triplet x : fList) {
    for (Triplet y : fList) {
        for (Pair z : sList) {
            if (x.noun1.equals(z.noun1) && y.noun2.equals(z.noun2)) {
                doSomething();
            } else if (x.noun2.equals(z.noun1) && y.noun1.equals(z.noun2)) {
                doSomethingElse();
            }
        }
    }
}