String cloudLink = String.format("%s/#service/testrun/%s/%s", cloudLinkPrefix, testRun.getProjectId(),
                testRun.getId());
        build.getActions().add(new CloudLink(build, cloudLink));

        RunInCloudEnvInject variable = new RunInCloudEnvInject("CLOUD_LINK", cloudLink);
        build.addAction(variable);