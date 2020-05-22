if (m1 < m2) {
    if (m % 2 == 0) {
        aStart = aStart + (->m<-/2) - 1;
        index = 1;
    }
    else {
        index = 2;
        aStart = aStart + ->m<-/2;
    }
    bEnd = bStart + ->n<- /2;
}