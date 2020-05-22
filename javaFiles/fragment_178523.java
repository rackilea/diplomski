value := 125.625
fractional part := value % 1
value := floor(value)

exponent = 1
listofvaluepairs = array()
while(value > 0)
{
  tmp_part := value % 10
  listofvaluepairs.add(value, exponent)
  exponent = exponent * 10
  value = floor(value / 10)
}