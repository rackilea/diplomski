#!/usr/bin/expect -f 

spawn java -jar algo1.jar

expect "enter your choice" {send "1\n"}
expect "enter a name :" {send "Peju, M.\n"}
expect "enter your choice" {send "2\n"}
expect "enter a name :" {send "Creasy, R. J.\n"}
expect "enter your choice" {send "0\n"}

exit