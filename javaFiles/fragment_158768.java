xquery version "3.0";
let $medline := '/db/Medline/Data'
let $doc := 'medline17n0001.xml'
let $PMID := request:get-parameter("PMID", "")
let $article := doc(concat($medline,'/',$doc))/PubmedArticleSet/PubmedArticle[MedlineCitation/PMID=$PMID]
return
$article