public boolean equals(Object o) {
    if(!(o instanceof Country))
         return false;
    Country c = (Country) o;
    if(this.population.equals(c.population) && this.continent.equals(c.continent))
        return true;
    return false;  
}