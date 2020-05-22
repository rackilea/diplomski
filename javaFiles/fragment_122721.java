success: function(doc) {
  var events = [];
 $.each( doc.el,function(i,v) {
    events.push({
      title: v.title,
      start: v.start,
      end: v.end,
      allDay: true,
      className: 'bgm-cyan', // will be parsed
    });
  });
  callback(events);
}