AddJobFlowStepsResult result = emr.addJobFlowSteps(new AddJobFlowStepsRequest()
            .withJobFlowId(clusterId)
            .withSteps(new StepConfig()
                    .withName(name)
                    .withActionOnFailure(ActionOnFailure.CONTINUE)
                    .withHadoopJarStep(new HadoopJarStepConfig()
                            .withJar("command-runner.jar")
                            .withArgs(stepargs))));