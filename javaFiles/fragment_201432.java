public class Pair {
    private Object left;
    private Object right;

    @java.beans.ConstructorProperties({ "left", "right" })
    Pair(Object left, Object right) {
        this.left = left;
        this.right = right;
    }

    public static PairBuilder builder() {
        return new PairBuilder();
    }

    public Object getLeft() {
        return this.left;
    }

    public Object getRight() {
        return this.right;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Pair)) return false;
        final Pair other = (Pair) o;
        final Object this$left = this.left;
        final Object other$left = other.left;
        if (this$left == null ? other$left != null : !this$left.equals(other$left)) return false;
        final Object this$right = this.right;
        final Object other$right = other.right;
        if (this$right == null ? other$right != null : !this$right.equals(other$right)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $left = this.left;
        result = result * PRIME + ($left == null ? 0 : $left.hashCode());
        final Object $right = this.right;
        result = result * PRIME + ($right == null ? 0 : $right.hashCode());
        return result;
    }

    public String toString() {
        return "Pair(left=" + this.left + ", right=" + this.right + ")";
    }

    public static class PairBuilder {
        private Object left;
        private Object right;

        PairBuilder() {
        }

        public Pair.PairBuilder left(Object left) {
            this.left = left;
            return this;
        }

        public Pair.PairBuilder right(Object right) {
            this.right = right;
            return this;
        }

        public Pair build() {
            return new Pair(left, right);
        }

        public String toString() {
            return "Pair.PairBuilder(left=" + this.left + ", right=" + this.right + ")";
        }
    }
}