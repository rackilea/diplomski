public String getTextAreaContent() {
  StringBuilder sb = new StringBuilder();
  for( Person p : personlist ) {
    if( sb.length() > 0 ) { //already content in the sb
      sb.append("\n"); //or maybe you'd need a <br>
    }

    sb.append( p.name );
  }

  return sb.toString();
}