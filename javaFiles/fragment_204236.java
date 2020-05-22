function indent(theText, indentCharCount) {
   for each character of the text...
      if it is an end-of-line character...
         concatenate spaces to return string using indentCharCount
      else if it is a '{' character...
         scan ahead through characters to find matching '}' character
         recursively call indent() function passing...
            characters between { and } for 'theText' param
            indentCharCount+2 for 'indentCharCount' param
         concatenate return value of indent() to return string
         set loop index so that the next character will be the matched '}'
      else (it's some other character)
         concatenate character to return string
   return the concatenated string
}