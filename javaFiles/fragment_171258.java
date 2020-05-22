ClassLoader dockerClientClassLoader = dockerClient.getClass().getClassLoader()
    Class callbackClass = dockerClientClassLoader.loadClass("com.github.dockerjava.core.command.ExecStartResultCallback")
    def callback = callbackClass.getDeclaredConstructor(OutputStream.class, OutputStream.class).newInstance(System.out, System.err);

    dockerClient.execStartCmd(execCreateCmdResponse.getId())
            .withDetach(false)
            .exec(callback)
            .awaitCompletion()