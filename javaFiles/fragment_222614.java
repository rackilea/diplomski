#!/bin/bash

if [ -z "$REMOTE" ] ; then 
    SCRIPTDIR=$(dirname "$0")
    "$SCRIPTDIR/mvn.orig" "$@"
else
    if [ -z "$REMOTE_BASE_DIR" ] ; then
        echo "ERROR: Please set environment variable REMOTE_BASE_DIR to the folder which contains the project directory"
        exit
    fi

    PROJECT_DIR=$(basename "$(pwd)")
    REMOTE_PROJECT_DIR=$REMOTE_BASE_DIR/$PROJECT_DIR/
    ARGS=
    for var in "$@"
    do
     ARGS="$ARGS \\\"$var\\\""
    done

    echo "Syncing project directory..."
    (set -x; rsync -aczhW --progress --delete --exclude '.git' --exclude 'target' $RSYNC_OPTS ./ "$REMOTE:\"$REMOTE_PROJECT_DIR\"")

    echo "Executing maven..."
    if [ "$REMOTE_PORT" = '${jpda.address}' ] ; then
        (set -x; ssh ${REMOTE} "cd \"$REMOTE_PROJECT_DIR\"; mvn $ARGS")
    else
        (set -x; ssh -R $REMOTE_PORT:localhost:$REMOTE_PORT ${REMOTE} "cd \"$REMOTE_PROJECT_DIR\"; mvn $ARGS")
    fi
fi