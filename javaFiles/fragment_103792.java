int ait = 0;
int bit = 0;
while(true) {
    if(ait < a.length && bit < b.length) {
        if(a[ait] <= b[bit])
            c[ait+bit] = a[ait++];
        else
            c[ait+bit] = b[bit++];
    } else if(ait < a.length) {
        c[ait+bit] = a[ait++];
    } else if(bit < b.length) {
        c[ait+bit] = b[bit++];
    } else {
        break;
    }
}