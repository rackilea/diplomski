void * address = env->GetDirectBufferAddress(bytebuffer);
int * firstInt = (int *)address;
int * secondInt = (int *)address + 1;
int * doubleCount = (int *)address + 2;
double * rest = (double *)((char *)address + 3 * sizeof(int));

// you said the third int represents the number of doubles following
for (int i = 0; i < doubleCount; i++) {
    double d = *rest + i; // or rest[i]
    // do something with the d double
}