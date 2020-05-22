input {
  tcp {
      port => 4560
      codec => multiline {
        pattern => "^\{$"
        negate => true
        what => previous
      }  
  }
}

filter {
  json { source => message }
}

output {
  elasticsearch {}
  stdout {}
}