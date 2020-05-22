#!/bin/bash

ORIG_STR="$1"
PATTERN="$2"
ARGS="$3"

paste -d '' <(echo "$ORIG_STR" | sed "s/[$PATTERN]/'\n'/g") <(echo "$ARGS" | sed "s/,/\n/g") | tr -d '\n' ;echo