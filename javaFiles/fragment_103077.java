public class Tra {

    /* Existing Code */

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;

        if (obj instanceof Tra) {
            Tra param = (Tra) obj;
            return this.x == param.x
                    && this.y == param.y
                    && this.z == param.z;
        }
    }
}