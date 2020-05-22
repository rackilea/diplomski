public E[] resize(){
        b = (E[]) new Object[a.length*2];
        for (int i = 0; i < a.length ; i++) {
            b[i] = a[i];
        }
        a = b;

    return resize();
}