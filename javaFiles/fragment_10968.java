ActiveResource ar = new ActiveResource().
Foo foo = new Foo();

ar.Fields.size() #=> 2
foo.Fields.size() #=> 4

ar.Fields.getKeys() #=> ["fileReference", "type", "node:created", "node:lastModified"]
foo.Fields.getKeys() #=> ["node:created", "node:lastModified"]


ar.Fields.CREATED_AT #=> "node:created"
foo.Fields.CREATED_AT #=> "node:created"
foo.Fields.TYPE #=> "type"
etc.