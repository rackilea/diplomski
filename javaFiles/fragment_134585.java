grammar T;

// options

tokens {
  DOC_COMMENT;
}

// rules

COMMENT
  :  '/*' (~'*' .*)? '*/'
  |  '/**' ~'/' .* '*/' {$type=DOC_COMMENT;}
  ;