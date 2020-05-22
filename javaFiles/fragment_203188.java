enum Color {
        RED, GREEN, BLUE;
        static final Map<String,Color> colorMap = 
        new HashMap<String,Color>();
        Color() {
            colorMap.put(toString(), this);
        }
    }