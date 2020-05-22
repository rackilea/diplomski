int count

def compile(Level a) {
    count = 0
    return compile(a, -1)
}   

def compile(Level a, int parentCount) {
  var aCount = count++
  return '''
    DefaultMutableTreeNode node«aCount» = new DefaultMutableTreeNode("«a.name»");
    «IF parentCount > -1»
      node«parentCount».add(node«aCount»);
    «ENDIF»
    «FOR b:a.sublevels»
      «compile(b, aCount)»
    «ENDFOR»
  '''
}