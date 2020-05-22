fN = fN.trim();
char fL = fN.charAt(fN.length()-1);

String[] suffixOdd = {"aith", "bael", "con", "dul", "evar", "faen", "gin", "har", "im", "jaal", "kas", "lihn", "'mek", "'nil", "oth", "pek", "quis", "reth", "sel", "thus", "uath", "vin", "waal", "'xol", "yl", "zara"};
String[] suffixEven = {"ae", "brar", "cael", "drimme", "emar", "fel", "gael", "hal", "ii", "jin", "ki", "lian", "mah", "nes", "onna", "pae", "'que", "ruil", "san", "thal", "ual", "vain", "wyn", "'xe", "yth", "zair"};

int suffixIndex = Character.toUpperCase(fL) - 'A';
if (fN.length() % 2 != 0)
{
    if(suffixIndex >= suffixOdd.length)
        return "";
    return suffixOdd[Character.toUpperCase(fL) - 'A'];
}
else
{
    if(suffixIndex >= suffixEven.length)
        return "";
    return suffixEven[Character.toUpperCase(fL) - 'A'];
}