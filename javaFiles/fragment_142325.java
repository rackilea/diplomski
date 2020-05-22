string source = @"Swipe(YN1) + Avg(DNA) * 0.5";
string argument = "calculate";  

string result = Regex.Replace(
    source, 
  @"(?<=[A-Za-z][A-Za-z0-9]*\s*\(\s*)[A-Z0-9]{2,3}(?=\s*\))", 
    match => match.Value + $", {argument}");

Console.Write(result);