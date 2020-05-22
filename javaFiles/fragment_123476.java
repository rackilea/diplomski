public List<Employee> parseEmployee() throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();

            switch (event) {
            case XMLStreamConstants.START_ELEMENT:
                if ("employee".equals(reader.getLocalName())) {
                    currentEmployee = new Employee();
                }
                if ("staff".equals(reader.getLocalName())) {
                    employeeList = new ArrayList<>();
                }
                if ("hiredate".equals(reader.getLocalName())) {
                    int yearAttr = Integer.parseInt(reader.getAttributeValue(
                            null, "year"));
                    int monthAttr = Integer.parseInt(reader.getAttributeValue(
                            null, "month"));
                    int dayAttr = Integer.parseInt(reader.getAttributeValue(
                            null, "day"));

                    currentEmployee
                            .setHireDay(yearAttr, monthAttr - 1, dayAttr);
                }
                break;

            case XMLStreamConstants.CHARACTERS:
                tagContent = reader.getText().trim();
                break;

            case XMLStreamConstants.END_ELEMENT:
                switch (reader.getLocalName()) {
                case "employee":
                    employeeList.add(currentEmployee);
                    break;
                case "name":
                    currentEmployee.setName(tagContent);
                    break;
                case "salary":
                    currentEmployee.setSalary(Double.parseDouble(tagContent));
                    break;
                }
            }
        }
        return employeeList;
    }