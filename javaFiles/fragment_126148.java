String temp;

if (fnum > part) {
    temp = fname + " krijgt  €" + (fnum - part) + " terug.";
}
else if (fnum < part) {
    temp = fname + " moet nog  €" + (part - fnum) + " betalen.";
}
else {
    temp = fname + " heeft alles betaald.";
}

JOptionPane.showMessageDialog(null, temp);