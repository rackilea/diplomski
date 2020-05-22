$ find . -name "*.jar" -print -exec jar -tf {} \;|egrep  "jar$|message_track.properties" | grep -B1 message_track.properties

./bar.jar
message_track.properties
./baz.jar
message_track.properties