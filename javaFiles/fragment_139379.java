#!/bin/bash

PATH=/some/path/bin:${PATH}      # Set our PATH
cd /path/to || exit 1            # Set the working directory
exec >> timeline.log 2>&1        # Direct output to a logfile
date                             # Write a timestamp to the log
exec java -jar timeline.jar      # Launch the command we came here for