String format = "location/{state}/{city}";
    String actualUrl = "location/washington/seattle";
    AntPathMatcher pathMatcher = new AntPathMatcher();
    Map<String, String> variables = pathMatcher.extractUriTemplateVariables(format, actualUrl);
    assertThat(variables.get("state"), is("washington"));
    assertThat(variables.get("city"), is("seattle"));