/**
   * Get the Generic Type T of a Type (Class/Interface) or extended/inherited Subtype: 
   * <pre>
   * {@code
   * public interface SomeInterface &lt;T&gt; { }
   * public interface SomeInterface extends SomeOtherInterface&lt;T&gt; { }
   * }
   * </pre>
   * @param implType
   * @param parentType
   * @return
   */