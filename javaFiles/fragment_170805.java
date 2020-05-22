data.forEach(function(d) {
        a = d.TEST_DATE.split(" ",1);
        b=a[0].split("/");
        f_date = b[1].concat("-").concat(b[0]).concat("-").concat(b[2]);
        //NEW LINES: add year, month and day fields to the data (*1 to convert to number)
        d.year = b[2]*1;
        d.month = b[0]*1;
        d.day = b[1]*1;
        console.log(d.TEST_DATE);           
        console.log(f_date);        
    })