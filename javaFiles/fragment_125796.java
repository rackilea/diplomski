$.getJSON("@{ViewContacts.getContactsTable()}", function(data) {                  
        var series = { 
            data: []
        };    
        $.each(data, function(index, item) {            
            series.data.push([parseInt(item.date), item.qty]);                
        }); 

        options.series.push(series);

        var chart = new Highcharts.Chart(options);
    });