grammar T;

tokens {
  // Some imaginary tokens:
  PLUS_SPECIAL;
  MINUS_SPECIAL;
}

// ...

num_addition
 : (a=num_multi -> $a) ( PLUS  b=num_multi -> ^(PLUS_SPECIAL  $num_addition $b)
                       | MINUS b=num_multi -> ^(MINUS_SPECIAL $num_addition $b)
                       )*
 ;

// ...

PLUS : '+';
MINUS : '-';