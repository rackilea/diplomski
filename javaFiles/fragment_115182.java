//Does Nothing
function (origStrWrp)
{
origStrWrp=new StringWrapper("Other String") // This only reassigns the copy of the reference and would give you the same problem
}
//Changes internal object
function (origStrWrp)
{
origStrWrp.myString = "Other String" // This doesn't change the reference, it changes the object that it refers to.
}