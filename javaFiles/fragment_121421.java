/configuration  GET Form for upload of Job configuration file
/files  GET List uploaded data files
/files  POST    Upload a new file (in a multipart form request) with path= and file= paremeters.
        /files  DELETE  Remove a file that was previously uploaded. Add pattern= parameter to narrow down to a subset of existing resources.
/files/{path}   GET Download a previously uploaded file. The path can contain directory separators.
        /home   GET List the resources available
/job-configuration  POST    Upload a Job configuration file as a String request body
/jobs   GET List the jobs known to the application. If they are configured in this application they are launchable, otherwise not (i.e. if they have been executed offline)
/jobs/executions    GET List all the job executions, in order of most recent to least.
/jobs/executions    DELETE  Stop all job executions
/jobs/executions/{jobExecutionId}   GET Show the JobExecution with the id provided
/jobs/executions/{jobExecutionId}   DELETE  Stop the JobExecution with the id provided. Add abort=true parameter to abort an already stopped or failed job.
/jobs/executions/{jobExecutionId}/steps GET List the StepExecutions of the JobExecution with the id provided
/jobs/executions/{jobExecutionId}/steps/{stepExecutionId}   GET Inspect the StepExecution with the id provided
/jobs/executions/{jobExecutionId}/steps/{stepExecutionId}/progress  GET Monitor the progress of the StepExecution with the id provided
/jobs/{jobName} GET List the JobInstances of the job name provided
/jobs/{jobName} POST    Execute the job with the name provided and parameters provided as a String (stringified Properties as per the CommandLineJobRunner)
/jobs/{jobName}/executions  GET List the JobExecutions for the job name provided
/jobs/{jobName}/{jobInstanceId}/executions  GET List the JobExecutions for the job instance with the id provided
/jobs/{jobName}/{jobInstanceId}/executions  POST    Stop the JobExecutions for the job instance with the id provided
/files.json GET
/home.json  GET
/job-configuration.json POST
/job-restarts.json  POST
/jobs.json  GET
/jobs/executions.json   GET
/jobs/executions.json   DELETE
/jobs/executions/{jobExecutionId}.json  GET
/jobs/executions/{jobExecutionId}.json  DELETE
/jobs/executions/{jobExecutionId}/steps/{stepExecutionId}.json  GET
/jobs/{jobName}.json    GET
/jobs/{jobName}.json    POST
/jobs/{jobName}/executions.json GET
/jobs/{jobName}/{jobInstanceId}.json    GET
/jobs/{jobName}/{jobInstanceId}/executions.json POST