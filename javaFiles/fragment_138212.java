Collection<OutputModel> outputModels = inputModel.stream()
    .map(im -> new OutputModel(im.getMonth(), im.getSalary(), im.getNoOfEmp()))
    .collect(Collectors.toMap(OutputModel::getMonth, Function.identity(),
        (m1, m2) -> new OutputModel(m1.getMonth(), m1.getSalary().add(m2.getSalary()),
            String.valueOf(Integer.valueOf(m1.getNoOfEmp()) + Integer.valueOf(m2.getNoOfEmp()))),
        LinkedHashMap::new))
    .values();