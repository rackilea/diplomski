String mainString = "hello world, you're full of weird things";
String findString = "ll";
String removeString = "hell";

String newString = mainString.Remove(mainString.IndexOf(removeString), removeString.Length);

if (newString.Contains(findString))
{
    return true;
}