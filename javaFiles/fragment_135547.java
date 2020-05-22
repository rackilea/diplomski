public class Incrementer implements Iterable<Integer> {
    int val, step, a, b;

    private Incrementer(int a, int b, int step) {
        this.step = step;
        this.a = a;
        this.b = b;
        if (step > 0)
            val = a;
        else
            val = b;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                if (step < 0 && val >= a)
                    return true;
                else if (step > 0 && val <= b)
                    return true;
                return false;
            }

            @Override
            public Integer next() {
                int ret = val;
                val += step;
                return ret;
            }

            @Override
            public void remove() {
            }
        };
    }

    public static Incrementer in(int a, int b) {
        ///tu zmieniamy tresc dla ostatniego przypadku

        if (a < b)
            return new Incrementer(a, b, 1);
        else
            return new Incrementer(b, a, -1);
    }

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

}