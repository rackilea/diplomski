public boolean IsChild(SED_PP sed)
{       
    if (this.children.contains(sed)) {
        return true;
    } 

    for (SED_PP s : this.children) {

        if (s.IsChild(sed)) {
            return true;
        }            
    }

    return false;
}