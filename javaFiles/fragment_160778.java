Transformer<Edge, Paint> edgePaint = new Transformer<Edge, Paint>() {
        public Paint transform(Edge s) {
            if (s.toString().equals("Inter"))
                return Color.RED;
            else
                return null;
        }
    };