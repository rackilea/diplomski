$(document).ready(function() {

            var calendar = $('#calendar').fullCalendar({
                header: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'month,agendaWeek,agendaDay'
                        },
                    selectable: true,
                    selectHelper: true,

                select: function(start, end, allDay) {
                        var title = prompt('Event Title:');
                        if (title) {
                            calendar.fullCalendar('renderEvent',
                            {
                                title: title,
                                start: start,
                                end: end,
                                allDay: allDay
                            },
                            true // make the event "stick"
                            );
                            }
                            calendar.fullCalendar('unselect');
                        },
                                editable: true,

                                eventSources: [
                                    {
                                            url: '/calendarDetails',
                                            type: 'GET',
                                            data: {
                                                start: 'start',
                                                end: 'end',
                                                id: 'id',
                                                title: 'title',
                                                allDay: 'allDay'
                                            },
                                            error: function () {
                                                alert('there was an error while fetching events!');
                                            }
                                    }
                            ]         
                    });
            });