* Start a job execution for the given {@link Job} and {@link JobParameters}
 * . If a {@link JobExecution} was able to be created successfully, it will
 * always be returned by this method, regardless of whether or not the
 * execution was successful. If there is a past {@link JobExecution} which
 * has paused, the same {@link JobExecution} is returned instead of a new
 * one created. A exception will only be thrown if there is a failure to
 * start the job. If the job encounters some error while processing, the
 * JobExecution will be returned, and the status will need to be inspected.