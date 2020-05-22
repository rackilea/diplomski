public boolean compareWith(Counter second) {

    if (this.getStart().equals(second.getStart()) 
            && this.getEnd().equals(second.getEnd())
            && this.getStart().equals(second.getEnd())) {
        return true;
    }

    return false;
}