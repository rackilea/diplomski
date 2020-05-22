@Override
public boolean equals(Object obj) {
    if (! (obj instanceof Term))
        return false;
    Term t = (Term)obj;
    return coef == t.coef && expo == t.expo; 
}