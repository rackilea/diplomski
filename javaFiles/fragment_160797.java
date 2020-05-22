index ind1 = 0;
index ind2 = 6;
float dst1 = sqrt(vert[ind1] - x) + sqrt(vert[ind1+1] - y);
float dst2 = sqrt(vert[ind2] - x) + sqrt(vert[ind2+1] - y);
// Make sure dst1 and dst2 are ordered to begin with
if (dst2 < dst1) {
    float td = dst1;
    dst1 = dst2;
    dst2 = td;
    ind1 = 6;
    ind2 = 0;
}
// Start loop at 12, because we have processed the first two indexes
for (int i = 12 ; i < vert.length; i += 6) {
    float dst = sqrt(vert[i] - x) + sqrt(vert[i+1] - y);
    if (dst >= dst2) {
        continue;
    }
    if (dst <= dst1) {
        dst2 = dst1;
        ind2 = ind1;
        dst1 = dst;
        ind1 = i;
    } else {
        dst2 = dst;
        ind2 = i;
    }
}