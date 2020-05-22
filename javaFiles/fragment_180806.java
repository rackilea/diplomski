private void configureState(String state, List<String> childStateList,
      StateConfigurer<String, String> stateConfigurer) {
    stateConfigurer.state(state);
    if (!childStateList.isEmpty()) {
      childStateList.forEach(childState -> {
        try {
          stateConfigurer.and().withStates().parent(state).initial(childState).state(childState);
        } catch (Exception e) {
          e.printStackTrace();
        }
      });
    }
  }