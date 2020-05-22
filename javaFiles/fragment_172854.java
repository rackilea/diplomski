// resize the underlying array
private void resize(int max) {
    assert max >= N;
    Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < N; i++) {
        temp[i] = q[(first + i) % q.length];   // <<< !!!
    }
    q = temp;
    first = 0;
    last  = N;
}