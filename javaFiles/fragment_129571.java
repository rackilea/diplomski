private static final Pattern imgRegExp  = Pattern.compile( "<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>" );
public send(email) throws Exception{

   Map<String, String> inlineImage = new HashMap<String, String>();
   String body = email.getBody();
   final Matcher matcher = imgRegExp.matcher( body );
   int i = 0;
   while ( matcher.find() ) {
      String src = matcher.group();
      if ( body.indexOf( src ) != -1 ) {
         String srcToken = "src=\"";
         int x = src.indexOf( srcToken );
         int y = src.indexOf( "\"", x + srcToken.length() );
         String srcText = src.substring( x + srcToken.length(), y );
         String cid = "image" + i;
         String newSrc = src.replace( srcText, "cid:" + cid );
         inlineImage.put( cid, srcText.split( "," )[1] );
         body = body.replace( src, newSrc );
         i++;
      }
   }
   Transport transport = mailSession.getTransport();
   MimeMessage message = new MimeMessage( mailSession );
   message.setSubject( email.getObjet() );
   message.setSender( new InternetAddress( email.getSender() ) );
   message.setFrom( new InternetAddress( email.getFrom()) );
   BodyPart bp = new MimeBodyPart();
   bp.setContent( body, "text/html" );
   MimeMultipart mmp = new MimeMultipart();
   mmp.addBodyPart( bp );
   Iterator<Entry<String, String>> it = inlineImage.entrySet().iterator();
   while ( it.hasNext() ) {
      Entry<String, String> pairs = it.next();
      PreencodedMimeBodyPart pmp = new PreencodedMimeBodyPart( "base64" );
      pmp.setHeader( "Content-ID", "<" + pairs.getKey() + ">" );
      pmp.setDisposition( MimeBodyPart.INLINE );
      pmp.setText( pairs.getValue() );
      mmp.addBodyPart( pmp );
   }
   message.setContent( mmp );
   message.addRecipient( Message.RecipientType.TO, new InternetAddress( email.getTo() ) );
   transport.connect();
   transport.sendMessage( message, message.getAllRecipients() );
   transport.close();
}