@Scheduled(fixedDelay = 1000)
  public void updateGauges() {
    multiGauge.register(userRepository.retrieveUsersGroupedByGender()
      .stream()
      .map(UserData::toRow)
      .collect(toList()), true);
  }