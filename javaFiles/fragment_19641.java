{
    "@timestamp" => 2016-11-14T13:23:38.304Z,
      "@version" => "1",
          "host" => "127.0.0.1",
       "message" => "<131>1 2016-11-14T13:23:38.302Z BirchBox.local MyApp - LogTest [mdc@18060 category=\"com.stackoverflow.Deeply\" exception=\"java.lang.RuntimeException: Exception message\n\tat com.stackoverflow.Deeply.complain(Deeply.java:10)\n\tat com.stackoverflow.Nested.complain(Nested.java:8)\n\tat com.stackoverflow.Main.main(Main.java:20)\n\" priority=\"ERROR\" thread=\"main\"] Example error\njava.lang.RuntimeException: Exception message\n\tat com.stackoverflow.Deeply.complain(Deeply.java:10)\n\tat com.stackoverflow.Nested.complain(Nested.java:8)\n\tat com.stackoverflow.Main.main(Main.java:20)",
          "type" => "syslog",
          "tags" => [
        [0] "_grokparsefailure"
    ]
}