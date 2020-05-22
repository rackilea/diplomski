Field p = new Field("p", "toto");
Fields fields = new Fields();
fields.put(p);

client.POST("http://localhost:"+PORT+"/model")
      .content(new FormContentProvider(fields))
      .send();