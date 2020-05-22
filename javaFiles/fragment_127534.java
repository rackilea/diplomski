String[] dates = new String[] {
  "2018-06-05 09:00:00",
  "2018-06-05 18:00:00"
};

var formatter = DateTimeFormat.ofPattern("yyyy-MM- HH:mm:ss");
var convertedTime = Arrays.stream(dates)
  .map(dateString -> LocalDateTime.parse(dateString, formatter))
  .collect(Collectors.toList());

var start = convertedTime.get(0);
var end = convertedTime.get(1);
var duration = Duration.between(start, end);

System.out.println(duration.toHours() + " hours has passed.");