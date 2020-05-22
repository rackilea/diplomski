OneMessage.getType match { 

  case OneMessage.Type.FOO => 

    val foo = OneMessage.getFoo
    // do the processing
    true

  case OneMessage.Type.BAR => 

    val bar = OneMessage.getBar
    // do the processing
    true

  case OneMessage.Type.BAZ => 

    val baz = OneMessage.getBaz
    // do the processing
    true

}