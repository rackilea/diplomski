// in the Term class
@Override
public boolean equals(Object o) {
    if (!(o instanceof Term)
        return false;
    Term t = (Term)o;
    return coeff == t.coeff && expo == t.expo;
}