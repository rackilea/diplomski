#email appender
log4j.appender.mail=com.horri.GmailAppender
#defines how othen emails are send
log4j.appender.mail.BufferSize=1
log4j.appender.mail.SMTPHost=smtp.gmail.com
log4j.appender.mail.From=yourmail@servermail.com
log4j.appender.mail.To=yourmail@gmail.com
log4j.appender.mail.startTLS = true
log4j.appender.mail.SMTPUsername=yourgmailusername
log4j.appender.mail.SMTPPassword=yourgmailpasswd
log4j.appender.mail.Subject=Log ...
log4j.appender.mail.threshold=error
log4j.appender.mail.layout=org.apache.log4j.PatternLayout
log4j.appender.mail.layout.ConversionPattern=%d{ABSOLUTE} %5p %c{1}:%L - %m%n