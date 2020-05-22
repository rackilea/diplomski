ARGS=

# Do nothing if there are no spaces; if there are spaces, surround with quotes
for arg in $(perl -pe '/ / or next; s/^/"/; s/$/"/' argument.dat); do
    ARGS="$ARGS $arg";
done

java $ARGS TestProgram