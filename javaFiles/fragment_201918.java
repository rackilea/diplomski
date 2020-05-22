char arr[] = { '0', '1', '2', '3', '4' };
const int LENGTH = sizeof arr / sizeof(*arr); // not necessary for char
assert(LENGTH > 1); // doesn't work for fewer than 2 elements

const int CYCLE = LENGTH - 1;
for (int i = 0; i < 100; ++i) { 
    printf("%c ", arr[ (i / CYCLE) & 1 ? CYCLE - i % CYCLE : i % CYCLE ]);
}
printf("\n");