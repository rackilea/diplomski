return employees.stream()
                .filter(e -> e.getSubordinates() != null)
                .collect(Collectors.toMap( //keyMapper
                        Employee::getId,
                        t -> {
                            List<Employee> subordinates = t.getSubordinates();
                            List<Employee> subOrdinatesListWithHighestSalary = new ArrayList<>();
                            int maxSal = Integer.MIN_VALUE;
                            for(Employee s: subordinates) {
                                if(s.getSalary() >= maxSal) {
                                    maxSal = s.getSalary();
                                }
                            }
                            for(Employee s: subordinates) {
                                if(s.getSalary() == maxSal) {
                                    subOrdinatesListWithHighestSalary.add(s);
                                }
                            }
                            return subOrdinatesListWithHighestSalary;
                        }));