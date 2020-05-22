public Hello clone() {
    Hello h;

    h = new Hello();
    h.mesg1 = this.mesg1;
    h.mesg2 = this.mesg2;
    h.c = this.c; // Or a deep copy if appropriate
    h.d = this.d; // Or a deep copy if appropriate

    return h;
}