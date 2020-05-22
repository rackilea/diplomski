class SampleObj{
  String attribute1
  List attribute2
  String attribute3
  String name

  @Override String toString() { name }
}

List<SampleObj> listA = [
    [name: "ObjA1", attribute1: "test", attribute2: ["a","b","c"]] as SampleObj,
    [name: "ObjA2", attribute1: "optionalArg test 2", attribute3: "optionalArg"] as SampleObj
]

List<SampleObj> listB = [
    [name: "ObjB1", attribute3: "test4", attribute2: [1,2,3]] as SampleObj,
    [name: "ObjB2", attribute3: "optionalArg"] as SampleObj,
    [name: "ObjB3", attribute1: "test", attribute2: ["a","b","c"]] as SampleObj
]

// there exists at least one object in list A whose attribute 1 value matches that of at least one object in list B (or vice versa)
assert hasMatches(listA, listB) { SampleObj aa, SampleObj bb -> aa?.attribute1 == bb?.attribute1 }

// there exists at least one object in list B whose attribute 3 value is a substring of the attribute 1 value of at least one object in list A (or vice versa)
assert hasMatches(listA, listB) { SampleObj aa, SampleObj bb -> bb?.attribute3 && aa?.attribute1?.contains(bb.attribute3) }

// there does not exist any object in list A whose attribute 1 value is contained in the attribute 2 list of any object in list B (or vice versa)
assert !hasMatches(listA, listB) { SampleObj aa, SampleObj bb -> aa?.attribute1 && bb?.attribute2?.contains(aa.attribute1) }