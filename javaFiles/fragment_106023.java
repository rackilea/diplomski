input {
    redis {
            port => 5566
            data_type => "list"
            key => "logstash"
    }
}

output {
    stdout {
        codec => rubydebug
    }
}