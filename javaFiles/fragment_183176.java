Model model = ...; // get your model from some place

Map<String, Object> properties = new HashMap<>();

BeanUtils.populate(model, properties);

// Exception handling and special cases left as an excercise