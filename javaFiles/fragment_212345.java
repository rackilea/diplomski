for (String token : swiftMessage.toString().split("\\s:")){
    //System.out.println(token);
    //lets ignore first `{4:` part
    //maybe like this
    if (token.length()<=3) continue;

    String[] key_value = token.split(":",2);
    System.out.println(":"+key_value[0]+"=>"+key_value[1]);
}