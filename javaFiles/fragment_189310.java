List<String> missingFieldNames =
    requiredFields.entrySet()
                  .stream()
                  .filter(entry -> StringUtils.isBlank(entry.getValue()))
                  .map(entry -> entry.getKey())
                  .collect(Collectors.toList());