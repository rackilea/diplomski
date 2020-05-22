setDateTime(dateTime) {
    let pipe = new DatePipe('en-US');

    const time = pipe.transform(dateTime, 'mediumTime', 'UTC');

    const date = pipe.transform(dateTime, 'MM/dd/yyyy', 'UTC');

    return date + ' ' + time;
  }