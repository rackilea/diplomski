# the json input
root@monitoring:~# cat tmp.json 
{"message":{"someField":"someValue"}}


# the logstash configuration file
root@monitoring:~# cat /etc/logstash/conf.d/test.conf
input {
  tcp {
    port => 5400
    codec => json
  }
}

filter{
}

output {
   stdout {
     codec => rubydebug
   }
}


# starting the logstash server
/opt/logstash/bin/logstash -f /etc/logstash/conf.d/test.conf


# sending the json to logstash with netcat
nc localhost 5400 <  tmp.json

# the logstash output via stdout
{
       "message" => {
        "someField" => "someValue"
    },
      "@version" => "1",
    "@timestamp" => "2016-02-02T13:31:18.703Z",
          "host" => "0:0:0:0:0:0:0:1",
          "port" => 56812
}