$ awk -vRS= '{print "====>" $0}' file
====>Mon, 01 Jan 2010 01:01:01
  Token1 = ValueXYZ
  Token2 = ValueABC
  Token3 = ValuePQR
  ...
  TokenX = Value123
====>Mon, 01 Jan 2010 01:02:01
  Token1 = ValueXYZ
  Token2 = ValueABC
  Token3 = ValuePQR
  ...
  TokenY = Value456
====>Mon, 01 Jan 2010 01:03:01
  Token1 = ValueXYZ
  Token2 = ValueABC
  Token3 = ValuePQR