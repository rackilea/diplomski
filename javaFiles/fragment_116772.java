myFunc:
    handler: com.mcm.in.MyHandler
    events:
     - http:
         path: user
         method: get
         cors: true
         integration: lambda
         request:
             template:
                 application/json: '{ "page" : "$input.params(''page'')" }'