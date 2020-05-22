List<String> allRules = result.getRules().stream()
        .map(name -> replace(name, RULES_PACKAGE_NAME, EMPTY))
        .collect(Collectors.toList());

    Set<String> businessRules = allRules.stream()
        .filter(name -> !NON_BUSINESS_RULES.contains(name))
        .collect(toSet());