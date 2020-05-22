CreateContainerResponse container1 = dockerClient
        .createContainerCmd("busybox")
        .withCmd("sleep", "9999")
        .withName("container1")
        .exec();
dockerClient.startContainerCmd(container1.getId()).exec();
...
CreateContainerResponse container2 = dockerClient
        .createContainerCmd("busybox")
        .withCmd("sleep", "9999")
        .withName("container2")
        .withLinks(new Link("container1", "container1Link"))
        .exec();
dockerClient.startContainerCmd(container2.getId()).exec();