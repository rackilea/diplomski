#StandardSQL    
CREATE TEMP FUNCTION
  test(a ARRAY<float64>)
  RETURNS ARRAY<float64>
  LANGUAGE js AS """
n=a.length;
for (var i=1;i<= n-1;i++)
{
a[i]+=a[i-1];
}
return a;
""";
WITH
  test AS (
  SELECT
    ARRAY<FLOAT64>[
    1,
    2,
    3,
    48,
    0] AS a)
SELECT
  test(a)
FROM
  test