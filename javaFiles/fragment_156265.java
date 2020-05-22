@Override
    public int compareTo(SoftwareProject rhs) {
        return Double.valueOf(this.cost).compareTo(rhs.cost);//you can even switch
                                                             //this.cost with rhs.cost
                                                             //or even write cost instead of this.cost
    }