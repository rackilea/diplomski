numDays = "<%= numDays%>";
            while (count <= numDays - 1) {
                  count = count + 1;
                  $("#btnAddRow").trigger("click");
            }

            function addRow(tableID) {
                var countCol = parseInt($('#dataTable').attr('data-countCol'), 10) || 1;
                countRow = countRow + 1;
                var index = $("#dataTable  tr:last").attr("id").split("_")[1];
                var rid = "r_" + (parseInt(index) + 1);
                var tempRow = $("#dataTable  tr:last").clone(true, true);
                tempRow.attr("id", rid);
                var checkCol = $('#dataTable tr:last td:first input');
                checkCol.prop("check", true);
                checkCol.prop("id", "check-" + index);
                var dateCol = $('#dataTable tr:last td:nth-child(2) input');
                dateCol.prop("readonly", true);
                var pv_dt = dateCol.val().split("/");
                pv_dt[0] = parseInt(pv_dt[0]) + 1;
                var nw_dt = pv_dt.join("/");
                $(tempRow).find('td:nth-child(2) input').val(nw_dt);
                tempRow.find('td:nth-child(3) input').prop('name', "rom_" + parseInt(countRow) + "." + countCol); 
                tempRow.find('td:nth-child(4) input').prop('name', "waste_" + parseInt(countRow) + "." + countCol); 
                tempRow.find('td:nth-child(5) input').prop('name', "fh_" + parseInt(countRow) + "." + countCol); 
                tempRow.find('td:nth-child(6) input').prop('name', "ot-rom_" + parseInt(countRow) + "." + countCol); 
                tempRow.find('td:nth-child(7) input').prop('name', "ot-waste_" + parseInt(countRow) + "." + countCol); 
                tempRow.find('td:nth-child(8) input').prop('name', "ot-FH_" + parseInt(countRow) + "." + countCol); 
                $('#dataTable').append(tempRow);
            }