public Hello(Hello original) {
    this.mesg1 = original.mesg1;
    this.mesg2 = original.mesg2;
    this.c = original.c; // Or a deep copy if appropriate
    this.d = original.d; // Or a deep copy if appropriate
}