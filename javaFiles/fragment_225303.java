grammar BooleanCalculator;

prog    
  :  rule+
  ;

rule
  :  boolean_expr {System.out.println($boolean_expr.b);}
  ;

boolean_expr returns [boolean b]
  : v1=num_statement ( '<'  v2=num_statement {$b = $v1.d < $v2.d;}
                     | '<=' v2=num_statement {$b = $v1.d <= $v2.d;}
                     | '='  v2=num_statement {$b = $v1.d == $v2.d;}
                     | '!=' v2=num_statement {$b = !($v1.d == $v2.d);}
                     | '>=' v2=num_statement {$b = $v1.d >= $v2.d;}
                     | '>'  v2=num_statement {$b = $v1.d > $v2.d;}  {System.out.println("v1=" + $v1.d + ", v2=" + $v2.d);}
                     )
  ;

num_statement returns [double d]
  :  v1=mult_statement {$d = $v1.d;} ( '+' v2=mult_statement {$d += $v2.d;}
                                     | '-' v2=mult_statement {$d -= $v2.d;}
                                     )* 
  ;

mult_statement returns [double d]
: v1=var {$d = $v1.d;} ( '*' v2=var {$d *= $v2.d;}
                       | '/' v2=var {$d /= $v2.d;}
                       | '%' v2=var {$d = $d/100*$v2.d;}
                       )*
;

var returns [double d]
  : NUMBER {$d = Double.parseDouble($NUMBER.text);}
  | '(' v1=num_statement ')' {$d = $v1.d;}
  ;

NUMBER  
  :  '0'..'9'+
  ;