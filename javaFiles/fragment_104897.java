String nombreHexa = h2d.getText().toString();
        if (isHex(nombreHexa) == true) {
            long deciLong = Long.parseLong(nombreHexa, 16);
            String newDeci = String.valueOf(deciLong);
            resulth2d.setText(newDeci);
        }