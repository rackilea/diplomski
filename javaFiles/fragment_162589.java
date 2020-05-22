$P{AUTHOR}.indexOf("[") < 0 
    ? $P{AUTHOR} 
    : $P{AUTHOR}.substring(0,$P{AUTHOR}.indexOf("[")) 
       + ($P{AUTHOR}.indexOf("[", $P{AUTHOR}.indexOf("[") + 1) > -1 
         ? $P{AUTHOR}.substring( $P{AUTHOR}.indexOf("[", $P{AUTHOR}.indexOf("[") + 1)) 
         : "")