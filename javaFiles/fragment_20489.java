#! /bin/sh
exactlyOne() {
  if [ "$#" != 1 ]; then
      echo "Found no or multiple matches"
      exit 1
  fi
  echo "$1"
}
lib=$(exactlyOne "/path/to/lib/newrelic-agent-"*.jar)
export JVM_OPTS="... -javaagent:$lib"