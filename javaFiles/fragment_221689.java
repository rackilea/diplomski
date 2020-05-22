try {
  // Create a default MimeMessage object.
  new MimeMessage(session).with { message ->
    // From, Subject and Content
    from = new InternetAddress( mailProp.from )
    subject = "My Subject!"
    setContent createMessage(), 'text/html'

    // Add recipients
    addRecipient( Message.RecipientType.TO, new InternetAddress( mailProp.to ) )

    // Send the message
    Transport.send( message )

    println "Sent successfully"
  }
}
catch( MessagingException mex ) {
    mex.printStackTrace()
}