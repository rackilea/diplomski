Format formatter;

// The year
formatter = new SimpleDateFormat("yy");    // 02
formatter = new SimpleDateFormat("yyyy");  // 2002

// The month
formatter = new SimpleDateFormat("M");     // 1
formatter = new SimpleDateFormat("MM");    // 01
formatter = new SimpleDateFormat("MMM");   // Jan
formatter = new SimpleDateFormat("MMMM");  // January

// The day
formatter = new SimpleDateFormat("d");     // 9
formatter = new SimpleDateFormat("dd");    // 09

// The day in week
formatter = new SimpleDateFormat("E");     // Wed
formatter = new SimpleDateFormat("EEEE");  // Wednesday

// Get today's date
Date date = new Date();