Pattern pattern = Pattern.compile("F_[ES]_[A-Za-z0-9]+_[A-Za-z0-9]+");
Matcher matcher = pattern.matcher(myStringToMatch);
if (matcher.matches())
{
  // Yeah, Baby!
}