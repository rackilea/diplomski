> d <- .jnew("java/util/Date","2013/12/08 08:00")
> d
[1] "Java-Object{Sun Dec 08 08:00:00 PST 2013}"

> # Java uses milliseconds, R expects seconds
> as.POSIXct(.jcall(d,"J","getTime")/1000, origin = "1960-01-01")
[1] "2003-12-08 08:00:00 PST"