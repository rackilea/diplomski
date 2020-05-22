Pushraven.setKey(my_key);

Notification raven = new Notification();
raven.title("MyTitle")
  .text("Hello World!")
  .color("#ff0000")
  .to(client_key);

Pushraven.push(raven);

raven.clear();