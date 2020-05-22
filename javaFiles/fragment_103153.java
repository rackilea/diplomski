$ find . -name "*.jar" -print -exec jar -tf {} \;|egrep  "jar$|message_track.properties"

./foo.jar
./bar.jar
message_track.properties
./baz.jar
message_track.properties