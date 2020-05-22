private String getJavaExecutable() throws MojoExecutionException {

    Toolchain tc = toolchainManager.getToolchainFromBuildContext("jdk", //NOI18N
                                                                 session);
    if (tc != null) {
      getLog().info("Toolchain in clojure-maven-plugin: " + tc);
      String foundExecutable = tc.findTool("java");
      if (foundExecutable != null) {
        return foundExecutable;
      } else {
        throw new MojoExecutionException("Unable to find 'java' executable for toolchain: " + tc);
      }
    }

    return "java";
  }