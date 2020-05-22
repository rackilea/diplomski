override getScope(EObject ctx, EReference ref) {
   if (ref == MyDslPackage.Literals.REFERENCE_THING) {
      return createScopeForThings()
   } else if (ref == MyDslPackage.Literals.REFERENCE_STUFF) {
      return createScopeForStuff()
   }
}