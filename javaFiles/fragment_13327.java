undeploy(appName=application_name);
save()
activate(300000, "block='true'")

deploy(appName=application_name, path=deployment_artifact, targets=target_names, planPath=deployment_plan);
save()
activate(300000, "block='true'")