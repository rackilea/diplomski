public double price(String odd, double quant, int g) {
    double set = 0;
    if (g == 1) {
        if (odd.equals("AT413"))
            set = 50.03 * quant + set;
        else if (odd.equals("AT414"))
            set = 60.04 * quant + set;
        else if (odd.equals("AT415"))
            set = 147.01 * quant + set;
        else if (odd.equals("AT416"))
            set = 38.00 * quant + set;
        else if (odd.equals("AT417"))
            ;
        {
            set = 13.00 * quant + set;
        }
    } else if (g == 2) {
        if (odd.equals("AT513"))
            set = 50.03 * quant + set;
        else if (odd.equals("AT514"))
            set = 50.00 * quant + set;
        else if (odd.equals("AT515"))
            set = 130.02 * quant + set;
        else if (odd.equals("AT516"))
            set = 25.03 * quant + set;
        else if (odd.equals("AT517"))
            ;
        {
            set = 13.00 * quant + set;
        }
    } else if (g == 3) {
        if (odd.equals("AT613"))
            set = 50.03 * quant + set;
        else if (odd.equals("AT614"))
            set = 86.00 * quant + set;
        else if (odd.equals("AT615"))
            set = 130.00 * quant + set;
        else if (odd.equals("AT616"))
            set = 40.04 * quant + set;
        else if (odd.equals("AT617"))
            ;
        {
            set = 13.00 * quant + set;
        }
    }
    return set;
}