tokens {
  TEXT;
}

rule
 : subrule1 subrule2 -> ^(TEXT["custom text here"] subrule1)
 ;