import static com.google.gwt.query.client.GQuery.*;
 [...]

  post( //GQuery post static method (you have get, ajax, getJSONP, etc)
      "http://url_to_the_jax-ws.server/MyService", 
      $$("{get:{id:5}}"),                     // GQuery json parses the parameters
      new Function(){                         // Callback
        public void f() {
          Properties p = getDataProperties(); // JSON response
          alert("success " + p.get("title"));
        }
      }
  );