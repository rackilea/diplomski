#! /bin/bash
lib=("/path/to/lib/newrelic-agent-"*.jar)
if [ "${#lib[@]}" != 1 ]; then
    echo "Found no or multiple versions of lib newrelic agent"
    exit 1
fi
export JVM_OPTS="... -javaagent:$lib"