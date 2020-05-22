Process rp = Runtime.getRuntime()
             .exec( "wscript \"" + path + "\" \"" + sayString + "\"");

// whenever user starts typing{
if(user.isTyping()){
  rp.destroy();
}