xstream.registerConverter(new CompanyConverter());

public Object unmarshal(HierarchicalStreamReader reader,UnmarshallingContext context) {

        Company comp = new Company();


        Set<Employee> packages = new LinkedHashSet<Employee>();

        while(reader.hasMoreChildren()){
            reader.moveDown();
            if("emp".equals(reader.getNodeName())){
                Employee emp = (Employee)context.convertAnother(comp, Employee.class);
                employees.add(emp);
            }
            reader.moveUp();
        }
        comp.setEmployees(employees);
        return comp;
    }