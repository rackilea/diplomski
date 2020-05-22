(
  (?<=   #Positive look behind
    [\(,;] #Finds all position that have bracket, comma and semicolon
  )   
  [A-Za-z_]\w* #After finding the positions, match all the allowed characters in variable name following that position
)