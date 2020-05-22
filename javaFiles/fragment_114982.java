RABBIT_LIB=$APP_HOME/lib/messagebus/rabbit
if [ -d "$RABBIT_LIB" ]; then
  for k in "$RABBIT_LIB"/*.jar; do
    CLASSPATH="$CLASSPATH":"$k"
  done
fi