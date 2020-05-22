for (int i=0 ; i < mEntity.size() ; i ++=) {
    Object obj = mEntity.get(i);
    if (obj instanceOf A) {
        A objA = (A) obj);
        objA.workerMethod();
    } else if (obj instanceOf D) {
        D objD = (D) obj;
        objD.workerMethod();
    }
}