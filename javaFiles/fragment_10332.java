object Stack {
  def ofType[T]( klass: java.lang.Class[T] ) = {
    val manifest =  new Manifest[T] {
      def erasure = klass
    }
    new Stack()(manifest)
  }
}