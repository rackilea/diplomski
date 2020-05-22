fun <T : Any, R : Any> T.copyPropsFrom(fromObject: R, vararg props: KProperty<*>) {
  // only consider mutable properties
  val mutableProps = this::class.memberProperties.filterIsInstance<KMutableProperty<*>>()
  // if source list is provided use that otherwise use all available properties
  val sourceProps = if (props.isEmpty()) fromObject::class.memberProperties else props.toList()
  // copy all matching
  mutableProps.forEach { targetProp ->
    sourceProps.find {
      // make sure properties have same name and compatible types 
      it.name == targetProp.name && targetProp.returnType.isSupertypeOf(it.returnType) 
    }?.let { matchingProp ->
      targetProp.setter.call(this, matchingProp.getter.call(fromObject))
    }
  }
}