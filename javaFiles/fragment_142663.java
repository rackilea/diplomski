% javadoc -charset "iso-8859-1" mypackage
         would insert the following line in the head of every generated page:

            <META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

         This META tag is described in the HTML standard @
         http://www.w3.org/TR/REC-html40/charset.html#h-5.2.2. (4197265 and 4137321)

      Also see -encoding and -docencoding.

      -docencoding  name
         Specifies the encoding of the generated HTML files. The name should be a preferred MIME name as given in the IANA Registry @
         http://www.iana.org/assignments/character-sets. If you omit this option but use -encoding, then the encoding of the generated