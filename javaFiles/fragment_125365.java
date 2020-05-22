filter{
  mutate {
    add_field => { 
      "exception" => "%{stack_trace}" 
    }
  }
  mutate {
    gsub => [
      "exception", "\n.*", ""
    ]
  }
}