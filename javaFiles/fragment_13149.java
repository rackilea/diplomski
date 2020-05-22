Phase: Outer_Pred
Input: Morph Lookup
Options: control = appelt

Rule: Outer_Pred (
  {Morph.pos == "verb", !Lookup.majorType == "yourInnerPredType"}
):tag
-->
:tag.Outer_Pred = {rule = "Outer_Pred"}