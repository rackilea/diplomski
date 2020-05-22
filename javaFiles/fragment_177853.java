StringBuffer content = new StringBuffer();
try {
    content.append(FreeMarkerTemplateUtils.processTemplateIntoString(
        configuration.getTemplate(templateName), templateVars));
} catch (IOException e) {
    // handle
} catch (TemplateException e) {
    // handle
}

message.setFrom(getMailFromName() + " <" + getMailFromAddr() + ">");
message.setTo(getMailTo());
if (getCcTo() != null)
    message.setCc(getCcTo());
message.setSubject(getSubject());
message.setText(content.toString());

mailSender.send(message);