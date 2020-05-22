@Override
public boolean equals(Object that) {
    if (that == null) {
        return false;
    }else if (this.getClass() != that.getClass()) {
        return false;
    }else if (this == that) {
        return true;
    }else{
        Term term = (Term) that;
        if ((term.coef) == (this.coef) && (term.expo) == (this.expo)) {
            return true;
        }
    }
    return false;
}