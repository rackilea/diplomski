// y = a[k]++;
aload_1
iload_2
dup2
iaload
dup_x2
iconst_1
iadd
iastore
istore_3

// y = ++a[k];   y = a[k] += 1;
aload_1
iload_2
dup2
iaload
iconst_1
iadd
dup_x2
iastore
istore_3

// y = a[k] = a[k] + 1;
aload_1
iload_2
aload_1
iload_2
iaload
iconst_1
iadd
dup_x2
iastore
istore_3