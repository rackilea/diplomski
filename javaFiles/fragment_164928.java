/**
   * Returns the current user name. This is the currently logged in user, unless that's been
   * overridden by the `SPARK_USER` environment variable.
   */
  def getCurrentUserName(): String = {
    Option(System.getenv("SPARK_USER"))
      .getOrElse(UserGroupInformation.getCurrentUser().getShortUserName())
  }