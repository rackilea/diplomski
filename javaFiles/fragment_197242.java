"declare variable $docName as xs:string external;" + sep +
                            "      for $book in doc($docName)/bookstore/book " +
                            "    where $book/year =2003 " +
                            "   return " +
                            "concat($book/author/text(),'&#xA;',$book/title/text())";
             System.out.println(tester.query(queryString));