#!/bin/bash

(
    until java -Xms256m -Xmx768m -jar MyApp.jar; do
        echo "MyApp crashed with exit code $?.  Respawning... " >&2
        sleep 5
    done
) &