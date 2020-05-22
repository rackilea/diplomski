public Molecule[][] ParseString(String formula) {
List[] temp = new List[] {
    new ArrayList<Molecule>(),
    new ArrayList<Molecule>()
};
List<Element> ell = new ArrayList<>();
String crnN = null;
int crnQ=0;
int side = 0;
for (int i=0;i<formula.length()+1;i++) {
    String d;
    try { d = formula.substring(i,i+1); } catch (Exception e) { d = formula.substring(i-1); }
    if (Character.isWhitespace(d.charAt(0))) continue;

    if (isNumber(d)) {
        crnQ = Integer.parseInt(crnQ+d);
    } else if (d == d.toUpperCase()) {
        if (crnN != null)
            ell.add(new Element(crnN,crnQ));
        crnN = d;
        crnQ = 0;
    } else {
        crnN = crnN + d;
    }
}

Molecule tempM = new Molecule();
boolean newMol = false;
for (Element e:ell) {
    String n = e.getName();

    if (n.charAt(0) == "+".charAt(0)) {
        newMol = true;
        temp[side].add(tempM);
        tempM = new Molecule();
    }
    if (n.charAt(0) == "=".charAt(0)) {
        newMol = true;
        if (side == 0)
            temp[side].add(tempM);
        side = 1;
        tempM = new Molecule();
    }
    if (n.charAt(0) == ">".charAt(0)) {
        side = 1;
        tempM = new Molecule();
        continue;
    }
    if (newMol) {
        newMol = false;
    } else {
        tempM.addElement(e);
    }
}
temp[1].add(tempM);

return new Molecule[][]{
        ((Molecule[]) temp[0].toArray(new Molecule[temp[0].size()])),
        ((Molecule[]) temp[1].toArray(new Molecule[temp[1].size()]))
};