String.metaClass.allIndexOf { pat ->
  def (ret, idx) = [ [], -2 ]
  while( ( idx = delegate.indexOf( pat, idx + 1 ) ) >= 0 ) {
    ret << idx
  }
  ret
}