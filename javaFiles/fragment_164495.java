$("select").change(function(){
              var arr = $(this).val()
               selectArr.push(arr);
               console.log(arr)
               populateRooms();
               clearArray();
            });