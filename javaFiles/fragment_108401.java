int current = 30;
int step = 4;
current -= step;
if (current < this.min) {
    current = this.min - current;
}
System.out.println(this.max - current); // this will give 87