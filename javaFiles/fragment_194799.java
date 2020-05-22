public class Observation {

    private RealVector attributes;

    public double distance(RealVector weight){
        return weight.distance(attributes);
    }
}

public class Neuron {

    private RealVector weight;

    public double distance(Observation obs) {
        return obs.distance(weight);
    }   
}