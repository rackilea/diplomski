while (poly != null) {
    if (poly.power > 0) {
        temp.next = new PolyNode(poly.coef * poly.power, poly.power - 1);
        temp = temp.next;
    }
    poly = poly.next;
}