public Incrementer by(int step) {
    if ((this.step<0)!=(step<0) && this.val==this.a)
        this.val = this.b;
    else if ((this.step<0)!=(step<0) && this.val==this.b) 
        this.val = this.a;
    else if (this.val!=this.a && this.val!=this.b) {
        this.val -= this.step;
        this.val += step;
    }
    this.step = step;

    return this;
}