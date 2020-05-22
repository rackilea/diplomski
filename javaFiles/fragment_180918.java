$(function() {
        var dates = $( "#from, #to" ).datepicker({
            dateFormat: 'dd-mm-yy',
            minDate: "+0D",
            defaultDate: "+0D",
            changeMonth: true,
            numberOfMonths: 1,
            onSelect: function( selectedDate ) {
                var option = this.id == "from" ? "minDate" : "maxDate",
                    instance = $( this ).data( "datepicker" ),
                    date = $.datepicker.parseDate(
                        instance.settings.dateFormat ||
                        $.datepicker._defaults.dateFormat,
                        selectedDate, instance.settings );
                this.id == "from" ? date.setDate(date.getDate()+1) : date.setDate(date.getDate()-1);
                dates.not( this ).datepicker( "option", option, date );
            }
        });
    });