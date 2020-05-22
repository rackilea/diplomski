declare function f:allows-id($e as element(*)) as xs:boolean {
   let $type-of-e := saxon:type($e)
   let $attUses := $type-of-e("attribute uses")
   let $attNames := $attUses ! .("attribute declaration") ! QName(.("target namespace"), .("name"))
   return $attNames = QName("", "id")
}