list = Arrays.stream(
            companyList.stream()
                 .filter(e -> e.equals("Compnay: National"))
                 .toArray())
           .map(Object::toString)
           .collect(Collectors.toList());