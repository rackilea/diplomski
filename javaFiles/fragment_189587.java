// y = x++;
iload_2
iinc          2, 1
istore_1

// y = ++x;   y = x += 1;   y = x = x + 1;
iinc          2, 1
iload_2
istore_1