public boolean isAncestor(member m){
        if (m == null)
            return false;
        if (mom.equals(m) || dad.equals(m))
            return true;
        else if(isAncestor(m.mom) || isAncestor(m.dad))
            return true;
        return false;
    }