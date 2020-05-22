(def-class MyStruct :extends    com.sun.jna.Structure
                    :implements [com.sun.jna.Structure$ByValue]
  ; Declare all the constructors, which just forward their
  ; arguments to the constructors of com.sun.jna.Structure
  (com.sun.jna.Structure [])
  (com.sun.jna.Structure [com.sun.jna.TypeMapper])
  (com.sun.jna.Structure [Integer])
  (com.sun.jna.Structure [Integer com.sun.jna.TypeMapper])
  (com.sun.jna.Structure [com.sun.jna.Pointer])
  (com.sun.jna.Structure [com.sun.jna.Pointer Integer])
  (com.sun.jna.Structure [com.sun.jna.Pointer Integer com.sun.jna.TypeMapper])

  ; Declare the fields of the struct
  ^Integer foo
  ^Integer bar
  ^Double  baz)