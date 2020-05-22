@Override
    public boolean equals(Object obj) {

        if (this == obj) return true; // is this right or should this be deleted

        if (obj == null || getClass() != obj.getClass()) return false;

        final MyProduct other = (MyProduct) obj;

        // If you prefer, the below two can be replaced with a single condition
        // price != null ^ other.price != null
        // Credits to @Andreas
        if (price == null && other.price != null) {
            return false;
        }
        if (price != null && other.price == null) {
            return false;
        }
        if (other.price != null && price.compareTo(other.price) != 0) {
            return false;
        }

        return super.equals(obj);
    }