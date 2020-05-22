for (int i = 0; i < list.size(); i++) {
    Node prev = mult.poly; //mult.poly is a pointer to the first node of the polynomial linked list 
    Node curr = mult.poly.next;

    do {
        if (curr.term.degree < prev.term.degree){ //compare degrees
            int temp2 = curr.term.degree;
            curr.term.degree = prev.term.degree;
            prev.term.degree = temp2;

            float temp3 = curr.term.coeff;
            curr.term.coeff = prev.term.coeff;
            prev.term.coeff = temp3;

            prev = mult.poly;
            curr = mult.poly.next;
        }

        prev = prev.next;
        curr = curr.next;
    } while(curr!=null);
}
return mult;