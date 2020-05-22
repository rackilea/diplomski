String makeRfc822email(String from, String to, String subject, String message) {
  StringBuilder builder = new StringBuilder();
  builder.append("From: ");
  builder.append(from);
  builder.append("\n");

  builder.append("To: ");
  builder.append(to);
  builder.append("\n");

  builder.append("Subject: ");
  builder.append(subject);
  builder.append("\n\n");  // Blank line before message.

  builder.append(message);

  return builder.toString();
}