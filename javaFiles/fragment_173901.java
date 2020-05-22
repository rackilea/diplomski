return employees.stream()
         .filter(e -> e.getSubordinates() != null)
         .collect(Collectors.toMap(Employee::getId,
                        t -> {
                            int maxSal = t.getSubordinates().stream().mapToInt(Employee::getSalary).max().orElse(Integer.MIN_VALUE);
                            return t.getSubordinates().stream().filter(x -> x.getSalary() == maxSal).collect(toCollection(ArrayList::new));

                        }));