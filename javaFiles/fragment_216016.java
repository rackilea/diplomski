// Scenario 1(a)
GenericParameter raw = /* some value */;
GenericParameter<?> wc = raw;

// Scenario 1(b)
Class raw = GenericParameter.class; 
Class<?> wc = raw;

// Scenario 2
Class<GenericParameter> classOfRaw = GenericParameter.class; 
Class<GenericParameter<?>> classOfWC = classOfRaw;