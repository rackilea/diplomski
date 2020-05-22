Man { Name = "Bill", Eyecolor = "blue", Height = 175, IsRich = true };

// will show Bill
SELECT * FROM Men WHERE height > 180 AND eyecolor = blue OR IsRich = 1
SELECT * FROM Men WHERE (height > 180 AND eyecolor = blue) OR IsRich = 1

// will not show Bill
SELECT * FROM Men WHERE height > 180 AND (eyecolor = blue OR IsRich = 1)