new Adapter<Double>() {
            @Override
            public Double adapt(String s) {
                return Double.valueOf(s);
            }
        }