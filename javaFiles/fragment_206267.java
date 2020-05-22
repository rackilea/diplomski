@Override
    public int compareTo(MThresholds thresholds) {
        if (contains(thresholds)) {
            return 1;
        }

        if (thresholds.contains(this)) {
            return -1;
        }

        throw new IllegalStateException("Thresholds overlap");
    }