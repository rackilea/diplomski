use strict;
use warnings;

my @samps = qw(

*date
 date*
 date
 date*date
*date*
 date*date*
*date*date
 date**
);

for my $str (@samps)
{
   print "\n'$str'\n";

   if ($str =~
       /
        ^          # Begin of string
        (?:             # Expr grouping
            [*]()          # Asterisk found then DEFINE capture group 1 as empty string
        )?              # End expr group, optional, if asterisk NOT found, capture group 1 stays UNDEFined
        date   #  'data'
        (?:             # Expr grouping
            (?!\1)           # Pseudo conditional: If no asterisk (group 1 is UNDEF), then
            [*](?:date)?     # look for '*' folowed by optional 'data'
          |               # OR,
        )                    # Asterisk or not, should be nothing here
        $          # End of string
      /x)

     {
         print "matched: '$str'\n";
     }
}