val json = """
            {
                "message" : "Hello" ,
                "args"    : [ 2, 3.234, 4,"good", true  ]
            }
            """

println(decode[Notification](json))