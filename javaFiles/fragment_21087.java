interface Foo {
  fun bar(x : (String) -> Unit)

  /* the following is only here for Java */
  @JvmDefault // this requires that you add -Xjvm-default=enable to your compiler flags!
  fun bar(x:Consumer<String>) = bar(x::accept)
}