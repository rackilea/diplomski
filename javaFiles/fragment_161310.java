{
  "name":"simplehello",
  "pomFile": {"groupId":"br.com.revo", "artifactId":"simplehello", "description":"the simplest JSF Project", "javaVersion":"1.7"},
  "models":[
    {"name":"Hello",
     "scope":"VIEW",
     "title":"Simple Hello",
     "mainPage":true,
     "fields":[{"type":"String", "name":"hello", "value":"\"Hello World!\""}],
     "actions":[{"actionType":"DISPLAY", "value":"#{helloBean.hello}"}]
    }
  ]
}