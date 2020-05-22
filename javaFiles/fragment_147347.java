grammar ...

options { ... }

tokens { T2; }

...

type
  : ( basicType -> basicType )
    ( basicType2 -> ^(T2 basicType2 basicType) )?
  ;

...