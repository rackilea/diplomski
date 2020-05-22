default domain Java~v8; -- specify v8 dialect of Java to manipulate

 rule reduce_strength_squared(e: term):
     :product -> product
 = "\e ^ 2 " ==> "\e * \e "
 if no_side_effects(e);

 rule optimize_divide_by_self(e: term):
     :product -> product
 = " \e / \e " => " 1 " if is_not_zero(e);

 rule accumulate_string(n: IDENTIFIER, a: expression, b: left_hand_side)
   : statement -> statement
 = "for (String \s: \a) { \b.add(\s); }"
 => "\b.addAll(\a);";

 rule eliminate_useless_if(x: expression, s: statement)
    : statement -> statement
 = "if (\x) \s; else \s; " -- generalizes OP's example
 => "\s;";

 rule left_factor_ternary(x: expression; t: left_hand_side; a: expression; b:expression)
      : statement -> statement
 =  "if (\x) { \t = \a;} else {\t = \b;} "
 =>  "\t = \x ? \a : \b ";

 rule convert_to_diamond( T1: qualified_path, T2: qualified_path,
                           C: qualified_path, 
                           i: IDENTIFIER, a: arglist)
       :statement -> statement
 =  "\T1<\T2> \i = new \C<\T2>(\a);"
 => "\T1<\T2> \i = new \C<>(\a);"

 rule merge_multi_catch( b:body, i1: IDENTIFIER, e1: qualified_path,
                                  i2: IDENTIFIER,  eh: body  )
       :statement -> statement
  = "try { \b }
     catch ( \i1: \e1 ) { \eh }
     catch ( \i2: \e1 ) { \eh }";
  => "try { \b }
     catch ( \i1, \i2: \e1 ) { \eh }";