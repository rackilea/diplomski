val repo = client.newServerEval()
repo.addVariable("url", getURI("evalstring", id))
repo.addVariable("content", (str))
repo.xquery(
    "declare variable  \$url as xs:string external ;"+
          "declare variable ${'$'}content external ;"+
          "xdmp:document-insert( \$url , xdmp:unquote( \$content ) )"
)

repo.eval().forEach {
  println(it.string)
}