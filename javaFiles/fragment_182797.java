public static boolean siegBedingung() {
    return (feld[ausgewählteReihe][0] == spielerSymbol && feld[ausgewählteReihe][1] == spielerSymbol
            && feld[ausgewählteReihe][2] == spielerSymbol)
            || (feld[0][ausgewählteSpalte] == spielerSymbol && feld[1][ausgewählteSpalte] == spielerSymbol
                    && feld[2][ausgewählteSpalte] == spielerSymbol)
            || (feld[1][1] == spielerSymbol && feld[2][2] == spielerSymbol && feld[0][0] == spielerSymbol)
            || (feld[0][2] == spielerSymbol && feld[1][1] == spielerSymbol && feld[2][0] == spielerSymbol);
}