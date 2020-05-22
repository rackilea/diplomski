Pattern:
         PositivePattern
         PositivePattern ; NegativePattern
 PositivePattern:
         Prefixopt Number Suffixopt
 NegativePattern:
         Prefixopt Number Suffixopt
 Prefix:
         any Unicode characters except \uFFFE, \uFFFF, and special characters
 Suffix:
         any Unicode characters except \uFFFE, \uFFFF, and special characters
 Number:
         Integer Exponentopt
         Integer . Fraction Exponentopt
 Integer:
         MinimumInteger
         #
         # Integer
         # , Integer
 MinimumInteger:
         0
         0 MinimumInteger
         0 , MinimumInteger
 Fraction:
         MinimumFractionopt OptionalFractionopt
 MinimumFraction:
         0 MinimumFractionopt
 OptionalFraction:
         # OptionalFractionopt
 Exponent:
         E MinimumExponent
 MinimumExponent:
         0 MinimumExponentopt