int key = num % 1009;

if (table[key] == 0) {
    table[key] = num;
} else {
    while (table[key = (key + 1) % table.length] != 0);
    table[key] = num;
}