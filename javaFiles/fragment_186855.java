@XmlElements
    ({
        @XmlElement(name = "Car", type = Car.class, required = false),
        @XmlElement(name = "Van", type = Van.class, required = false)
    })    
    public List<Vehicle> getListOfVehicles()
    {
        return vehicleCollection;
    }