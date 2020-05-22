function getCustomerMap() {
    $.ajax({
        url: serverUrl + "/getMap",
        success: function (data) {
            var map = JSON.parse(data);
            var arr = new Array();
            for (var key in map)
                arr.push(map[key]); // add the map values to the array

            // sort the array by name
            arr.sort(function(a, b){
                if (a.name < b.name)
                    return -1;
                if (a.name > b.name)
                    return 1;
                return 0;
            });

            // iterate by array index and append the list items.
            // now you use the id field of the objects as your data-user values.
            for (var i in arr)
                $('#users').append('<li data-user="' + arr[i].id + '"><a>' + arr[i].name + '</a></li>');
        }
    });
}