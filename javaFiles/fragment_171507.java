@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "capital",
    "population",
    "states"
})
@XmlRootElement(name = "Country")
public class Country {
@XmlElement(required = true)
protected String name;
@XmlElement(required = true)
protected String capital;
@XmlElement(required = true)
protected String population;
@XmlElement(required = true)
protected Country.States states;
    public String getName() {
        return name;
    }
    public void setName(String value) {
        this.name = value;
    }
    public String getCapital() {
        return capital;
    }
    public void setCapital(String value) {
        this.capital = value;
    }
    public String getPopulation() {
        return population;
    }
    public void setPopulation(String value) {
        this.population = value;
    }
    public Country.States getStates() {
        return states;
    }
    public void setStates(Country.States value) {
        this.states = value;
    }