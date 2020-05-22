String.metaClass.allIndexOf { pat ->
  def ret = []
  delegate.findAll pat, { s ->
    def idx = -2
    while( ( idx = delegate.indexOf( s, idx + 1 ) ) >= 0 ) {
      ret << idx
    }
  }
  ret
}