$(document).ready(function() { 
     var calendar =  $('#calendar').fullCalendar({
        header: {
            left: 'title',
            center: 'agendaDay,agendaWeek,month',
            right: 'prev,next today'
        },
        eventClick: function(event, jsEvent, view) {
          alert('Event: ' + event.title);
          alert('start date event: ' + event.start._i); 
        }
});