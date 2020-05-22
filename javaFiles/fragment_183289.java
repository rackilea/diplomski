String decoderesult = result.get("decodeResult");
if (decoderesult.toLowerCase().startsWith("k")) {
    cardnumberbox.setText(decoderesult);
} else if (decoderesult.toLowerCase().startsWith("r")) {
    shelfnumberbox.setText(decoderesult);
}