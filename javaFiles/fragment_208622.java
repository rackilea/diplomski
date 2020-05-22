/* int a = 5; */
int* a = malloc(sizeof(int)); // or `new` in C++
*a = 5;

/* int z = 3; */
int* z = malloc(sizeof(int));
*z = 3;

/* a = z; */
free(a); // or `delete` in C++
a = malloc(sizeof(int));
*a = *z;