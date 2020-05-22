public String toString() {
    StringBuilder b = new StringBuilder();

    b.append("In klas ");
    b.append(this.klasCode);
    b.append(" zitten de volgende leerlingen:\n");

    deLeerlingen.forEach(leerlingen -> {
        b.append(leerlingen.toString());
    });

    return b.toString();
}