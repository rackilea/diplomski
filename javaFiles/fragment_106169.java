jq.ajax({type: 'POST', url: '/SpringjQueryTest/dev/main/ajax/bean', data: number, contentType: 'application/json', 

        success: function(data) {
            alert("Added Number below the button");
            alert(data);

        }});