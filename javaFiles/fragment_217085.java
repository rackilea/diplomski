RSet1 = query("SELECT dept_name, COUNT(*) AS COUNT FROM student GROUP BY dept_name;");
RSet2 = query("SELECT MAX(ACOUNT) AS MAXCOUNT ...");
RowInR2 = RSet2[0]; // first and only row

foreach RowInR1 in RSet1
    if (
        RowInR1.count = RowInR2.maxcount
    ) {
        return RowInR1; // this is your result
    }
}