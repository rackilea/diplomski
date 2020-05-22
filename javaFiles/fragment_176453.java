// applying the surcharge using zip code
    if (zipCode2 == '4') {
        surcharge = (shipping * .05);
        JOptionPane.showMessageDialog(null, "Your surcharge cost at 5% is: $" + surcharge);
    } else if (zipCode2 == '9') {
        surcharge = (shipping * .09);
        JOptionPane.showMessageDialog(null, "Your surcharge cost at 9% is: $" + surcharge);
    } else {
        surcharge = (shipping * .14);
        JOptionPane.showMessageDialog(null, "Your surcharge cost at 14% is: $" + surcharge);
    }