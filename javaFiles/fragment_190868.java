// US culture
var usCulture = new CultureInfo("en-US");
// Get current UTC time.   
var utcDate = DateTime.UtcNow;
// Change time to match GMT + 1.
var gmt1Date = TimeZoneInfo.ConvertTimeBySystemTimeZoneId(utcDate, "W. Europe Standard Time");
// Output the GMT+1 time in our specified format using the US-culture. 
var str = gmt1Date.ToString("ddd, dd MMM yyyy HH:mm:ss z", usCulture);