yourList.stream()
         .collect(Collectors.toMap(
                  EmployeeContract::getId,
                  Function.identity(),
                  BinaryOperator.maxBy(Comparator.comparing(EmployeeContract::getDate)))
            )
         .values();