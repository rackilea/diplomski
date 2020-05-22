@Autowired
JavaMailSenderImpl sender;
// ...

MimeMessage message = sender.createMimeMessage();
MimeMessageHelper helper = new MimeMessageHelper(message);
helper.setTo("someone@host1.com");
message.setFrom("me@host2.com");
Map model = new HashMap();
model.put("username", "Foo");
String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "some/package/templates/hello.html", model);
message.setText(text, true);

//...
sender.send(message);