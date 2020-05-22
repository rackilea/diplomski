jq.post("/SpringjQueryTest/dev/main/ajax/bean", number,

        function(data) {
            alert("Added Number below the button");
            alert(data);

        });