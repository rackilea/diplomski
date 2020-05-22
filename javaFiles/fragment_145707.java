DockerClient dockerClient = DockerClientBuilder.getInstance().build();
ListContainersCmd listContainersCmd = dockerClient.listContainersCmd().withShowAll(true);
    for (Container container: listContainersCmd.exec()) {
        if (container.toString().contains("192.168.1.105")){
            dockerClient.restartContainerCmd(container.getId()).exec();
        }
    }