import fj.F;
import fj.F5;
import fj.P5;

public abstract class F5Optional<At, Bt, Ct, Dt, Et, Ft> extends F5<At, Bt, Ct, Dt, Et, Ft> {

    public final F<P5<At, Bt, Ct, Dt, Et>, Ft> tupleize() {
        return new F<P5<At, Bt, Ct, Dt, Et>, Ft>() {

            @Override
            public Ft f(final P5<At, Bt, Ct, Dt, Et> p) {
                return F5Optional.this.f(p._1(), p._2(), p._3(), p._4(), p._5());
            }
        };
    }

}