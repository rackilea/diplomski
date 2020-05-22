List<Employee> filter = Linq4j.asEnumerable(Arrays.asList(emps)).orderBy(new Function1<Employee, Integer>() {
            public Integer apply(Employee arg0) {
                return arg0.deptno;
            }

        }).orderBy(new Function1<Employee, String>() {
            public String apply(Employee arg0) {
                return arg0.name;
            }

        }).toList();