return Optional.ofNullable(apiKey)
                .filter(StringUtils::isNotBlank)
                .map(ak -> userAgent)
                .map("ALFA"::equalsIgnoreCase)
                .map(isAlfa -> isAlfa ? ALFA_TYPE : BETA_TYPE)
                .map(type -> ispropertyExists(type, apiKey))
                .orElse(false);