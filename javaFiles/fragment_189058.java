public abstract class EqualsTest {
    public final boolean equals(Object o) {//make equals final to maintain symmetry
        if (o instanceof EqualsTest) {//use instanceof
            EqualsTest e = (EqualsTest)o;//cast and assign to EqualTest reference
            return e.getOperand().equals(this.getOperand());//use equals here
        } else
            return false;
        }
    }
}