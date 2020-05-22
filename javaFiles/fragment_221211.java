"initComplete": function() {
    if ($(this).attr('id') == "tableBuildings") {
        var dates = $('#tableBuildings tr td:first-child').toArray();

        populate_dropdown(dates);

        $.fn.dataTable.ext.search.push( function( settings, data, dataIndex, rowData, counter ) {
            if (settings.nTable.id === 'tableBuildings') {

                //Calculation of beggining and ending of the room
                var yearsBuildig = $("#filtre_saison").val().split(' ')[1];
                var initialDate = new Date(yearsBuildig.split('/')[0],10,01);
                var endDate = new Date(initialDate.getFullYear() + 1, initialDate.getMonth(), initialDate.getDate());

                //Calculation of the Date object of the PFHA
                var year = Number(rowData.initialDate.display.split(' ')[0].split('/')[2]);
                var month = Number(rowData.initialDate.display.split(' ')[0].split('/')[1] - 1);
                var day = Number(rowData.initialDate.display.split(' ')[0].split('/')[0]);
                var hours = Number(rowData.initialDate.display.split(' ')[1].split(':')[2]);
                var buildingDate = new Date(year, month, day);

                if (buildingDate >= initialDate && buildingDate < endDate) {
                    return true;
                } else {
                    //this row doesn't contain that year, let's hide the whole <tr>
                    return false;
                }

            } else {
                return true;
            }
        });

        $('#filtre_saison').on('change', function() {
            table.draw();
        });

        table.draw();
    }
}

function populate_dropdown(dates) {
    // make an empty array variable to hold the list of building
    var building = [];

    // loop through the dates
    for (var i = 0; i < dates.length; i++) {

        var year = Number($(dates[i]).html().split(' ')[0].split('/')[2]);
        var month = Number($(dates[i]).html().split(' ')[0].split('/')[1] - 1);
        var day = Number($(dates[i]).html().split(' ')[0].split('/')[0]);
        var buildingDate = new Date(year, month, day);

        var initialDateRoom = new Date(year, 10, 1);

        // now let's calculate the room
        var room;
        if (buildingDate < initialDateRoom) {
            room = Number(year-1) + "/" + year;
        } else {
            room = year + "/" + Number(year+1);
        }

        // now let's add that room to the building array (if it's not already in the array!)
        if ($.inArray(room, building) == -1) {
            building.push(room);
        }
    }

    // now that we're done looping through and building the building list, let's sort the array
    building.sort();

    // make a variable to hold all the <option> fields for the select dropdown
    var options = "";

    // loop through the years and make the options fields
    $.each(building, function(key,value) {
        options += "<option> room " + value + "</option>";
    }); 

    // take the new options string that we've built and put it inside the <select> dropdown
    $('#filtre_saison').append(options);
}