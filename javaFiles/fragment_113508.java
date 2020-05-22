Option<StructType> maybeStructure = person.recordStruct();
if (maybeStructure.isEmpty()) { 
    // do something if None
} else {
    StructType structure =  person.recordStruct().get();
    // now you can use structure...
}