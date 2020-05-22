select Col3,MyOption from MyOption where OptionKey in (?,?,?,?) and ID = " + _Id";

while(rs.hasNext()) {
  String option = rs.getString(2);
  String optionValue = rs.getString(1);
  String propertyName = null;
  if(option.contains("imap")) {
    switch(options) {
      case "Mail.IMAP.Server":
        propertyName = "mail.imap.host";
        break;
      case "Mail.IMAP.Port":
        propertyName = "mail.imap.port";
        break;
      case "Mail.IMAP.AuthUser":
        propertyName = "mail.imap.auth";
        break;
      case "Mail.IMAP.UseTLS":
        propertyName = "mail.imap.starttls.enable";
        break;
    }
    if(null != propertyName) {
      properties.setProperty(propertyName, optionValue);
    }
  }
}