opts=( )
if [[ -n "$homeOption" ]]; then
    opts+=( "$homeOption" )
fi

java "${opts[@]}" -cp "$classPath" "com.civilizer.extra.tools.DataBroker" -import "$importPath"