int w = 3000;
int h = 3000;

int[] array = new int[w * h];

/* Here is how to calculate the index for a specific (x, y) */
int index = y * w + x;

array[index] = 5;