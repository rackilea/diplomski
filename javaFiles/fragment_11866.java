pascal@laptop:~/tmp/$ svn co http://wiquery.googlecode.com/svn/branches/1.0-m2 wiquery
...
pascal@laptop:~/tmp/$ cd wiquery
pascal@laptop:~/tmp/wiquery$ mvn validate
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Building WiQuery project
[INFO]    task-segment: [validate]
[INFO] ------------------------------------------------------------------------
[INFO] [buildnumber:create {execution: default}]
[INFO] Checking for local modifications: skipped.
[INFO] Updating project files from SCM: skipped.
[INFO] Executing: /bin/sh -c cd /home/pascal/tmp/wiquery && svn --non-interactive info
[INFO] Working directory: /home/pascal/tmp/wiquery
[INFO] Storing buildNumber: 208 at timestamp: 1256499766371
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESSFUL
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 3 seconds
[INFO] Finished at: Sun Oct 25 20:42:46 CET 2009
[INFO] Final Memory: 13M/77M
[INFO] ------------------------------------------------------------------------
pascal@laptop:~/tmp/wiquery$