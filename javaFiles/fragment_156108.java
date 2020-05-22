BUILD_NUMBER
The current build number, such as "153"
BUILD_ID
The current build id, such as "2005-08-22_23-59-59" (YYYY-MM-DD_hh-mm-ss)
BUILD_DISPLAY_NAME
The display name of the current build, which is something like "#153" by default.
JOB_NAME
Name of the project of this build, such as "foo" or "foo/bar". (To strip off folder paths from a Bourne shell script, try: ${JOB_NAME##*/})