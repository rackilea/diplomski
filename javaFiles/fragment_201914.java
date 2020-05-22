export _JAVA_OPTIONS="-Xmx20m";
java Test
>> Picked up _JAVA_OPTIONS: -Xmx20m
>> mem: 19601168
>> total mem: 20447232

java -Xmx123m Test
>> Picked up _JAVA_OPTIONS: -Xmx20m
>> mem: 19601320
>> total mem: 20447232

# clear java options
export _JAVA_OPTIONS=
java -Xmx123m Test
>> Picked up _JAVA_OPTIONS: 
>> mem: 121773128
>> total mem: 123731968