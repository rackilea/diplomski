input {
    file {
        path => "/tmp/access_log"
        start_position => "beginning"
    }
}


filter {
    if [message] !~ "^WARC-Target-URI" and [message] !~ "^HTTP\/1.1" and [message] !~ "^Date: " {
        drop {}
    }

    grok {
        match => {
            "message" => ["Date: %{GREEDYDATA:date}", "WARC-Target-URI: %{GREEDYDATA:url}", "HTTP/1.1 %{NUMBER:response}"]
        }
    }

    # For "Wed, 30 Apr 2008 20:48:25 GMT"
    date {
        match => ["date", "EEE, dd MMM YYYY HH:mm:ss ZZZ"]
        target => "date"
        locale => "en"
    }
}

output {
    elasticsearch {
        hosts => ["localhost:9200"]
        index => "webinfo"
    }
}