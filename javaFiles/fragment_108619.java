interface Processor<T>{
    public void process(String s, List<T> result);
}

class BuildingProcessor implements Processor<Building>{
    @Override
    public void process(String s, List<Building> result) {
        result.add(new Building());
    }
}

class EmployeeProcessor implements Processor<Employee>{
    @Override
    public void process(String s, List<Employee> result) {
        result.add(new Employee());
    }
}