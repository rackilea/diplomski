$.ajax({
        url:"ServletPost",
        type:"POST",
        dataType:'json',
        data: {rows:rowValues, columns:columnValues},
        success:function(data){
            // codes....
        }

    });