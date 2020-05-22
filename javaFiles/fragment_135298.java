static List<String> alertNames;

static {
  alertNames = Arrays.stream(MenuAlertEnum.values())
                      .map(MenuAlertEnum::getAlertName)
                      .collect(Collectors.toList());
}