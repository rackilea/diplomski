sort -k 3,3 request.log | awk '
    BEGIN {
        print "startTimestamp;endTimestamp;requestType;responseCode;URL;typ;responsetime"
        split("", request)
    }
    $4 == "->" {
        printLine()
        split($0, request)
        split("", response)
    }
    $4 == "<-" {
        split($0, response)
    }
    END {
        printLine()
    }
    function printLine() {
        if (length(request)) {
            print request[1] ";" response[1] ";" request[5] ";" response[5] ";" request[6] ";" response[6] ";" response[7]
        }
    }'