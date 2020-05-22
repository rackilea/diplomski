public class Country implements Comparable<Country>{

    public static void main(String[] args){
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("10,979"));
        countries.add(new Country("2,313,973,713"));
        countries.add(new Country("134"));
        countries.add(new Country("321"));
        countries.add(new Country("52,851"));
        countries.add(new Country("134"));

        Collections.sort(countries);

        for(Country country : countries)
            System.out.println(country.getPopulation());
    }

    private String population;

    public Country(String population){
        this.population = population;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    @Override
    public int compareTo(Country o) { //will break unless input is numbers or "," seperated numbers
        String temp1 = population.replaceAll(",", "");
        String temp2 = o.population.replaceAll(",", "");

        if(temp1.length() > temp2.length())
            return 1;
        else if(temp2.length() > temp1.length())
            return -1;
        else
        {
            char[] pop1 = temp1.toCharArray();
            char[] pop2 = temp2.toCharArray();
            for(int i = 0; i < temp1.length(); i++){
                if(Integer.parseInt(String.valueOf(pop1[i])) > Integer.parseInt(String.valueOf(pop2[i])))
                    return 1;
                else if(Integer.parseInt(String.valueOf(pop1[i])) < Integer.parseInt(String.valueOf(pop2[i])))
                    return -1;
            }
            return 0;
        }
    }
}