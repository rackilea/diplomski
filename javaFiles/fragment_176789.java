query: query_first SEMICOLON
     | query_first ignoreHiddenFilesPart (followSymlinksPArt)? SEMICOLON
     | query_first followSymlinksPArt (ignoreHiddenFilesPart)? SEMICOLON
     ;
query_first : SELECT  selectAttribute (',' selectAttribute)*
      FROM from
      (WHERE where=booleanExpression)?
      (ORDER BY sortItem (',' sortItem)*)?
      (LIMIT limit=(INTEGER_VALUE | ALL))?
            ;
ignoreHiddenFilesPart: IGNOREHIDDENFILES ignoreHiddenFiles=booleanValue ;
followSymlinksPArt: FOLLOWSYMLINKS followSymlinks=booleanValue ;