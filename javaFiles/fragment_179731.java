int i = 0;
int index = 20;
while (index > 0) {
    i++;
    if (i == x.length) i = 0;
    --index;
}
char val = x[i];