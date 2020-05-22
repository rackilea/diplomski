int best = 0;
for (int i=0; i<A.length; i++) {
    int c = find(top, A[i]) - i;
    if (c > best) best = c;
    if (best >= A.length-i) return best;
}

return best;