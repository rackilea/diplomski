if (col == 3 && data.equalsIgnoreCase("successful") && !data.isEmpty()) {
        c.setBackground(Color.GREEN);
    }
    else if (col == 3 && !data.equalsIgnoreCase("successful") && !data.isEmpty()) {
        c.setBackground(new Color(255, 51, 51));
    }
    else {
        c.setBackground(Color.GRAY.brighter());
    }