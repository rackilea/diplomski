<fonttbl>   '{' \fonttbl (<fontinfo> | ('{' <fontinfo> '}'))+ '}'
<fontinfo>  <themefont>? \fN <fontfamily> \fcharsetN? \fprq? <panose>? <nontaggedname>?
    <fontemb>? \cpgN? <fontname> <fontaltname>? ';' 
<themefont> \flomajor | \fhimajor | \fdbmajor | \fbimajor | \flominor | \fhiminor |
    \fdbminor | \fbiminor
<fontfamily>    \fnil | \froman | \fswiss | \fmodern | \fscript | \fdecor | \ftech | 
    \fbidi
<panose>    '{\*' \panose <data> '}'
<nontaggedname> '{\*' \fname #PCDATA ';}'
<fontname>  #PCDATA
<fontaltname>   '{\*' \falt #PCDATA '}'
<fontemb>   '{\*' \fontemb <fonttype> <fontfname>? <data>? '}'
<fonttype>  \ftnil | \fttruetype
<fontfname> '{\*' \fontfile \cpgN? #PCDATA '}'