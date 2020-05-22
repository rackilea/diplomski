^ # match start of string
 [+-]? # matches optional + or - sign
 [0-9]{1,3} # match one or more digits 
 (,[0-9]{3})* # match zero or more groups of comma plus three digits
 (\. # match literal dot
  [0-9]+ # match one or more digits
 )? # makes the decimal portion optional
$ # match end of string