define("NUM_PER_ITERATION", 1000);

// Get our ID range
$query = "SELECT MIN(ID) AS MinID, MAX(ID) AS MaxID FROM Users";
$array = $MyDB->GetSingleRow($query);
$minid = (int) $array["MinID"];
$maxid = (int) $array["MaxID"];

// Get our last starting point
$startingpoint = LoadLastWorkPosition();
if (!$startingpoint || $startingpoint < $minid) {
  $startingpoint = $minid;
} else if ($startingpoint > $maxid) {
  echo("Already done!");
  exit;
}

// Run through the values
$curstart = $startingpoint;
while ($curstart <= $maxid) {
  $curend = $curstart + NUM_PER_ITERATION - 1;

  // Set a time out so it will keep running, you'll know way better
  // than I how long this should be for each loop
  set_time_limit(300);

  // Handle a number of results
  HandleResults($curstart, $curend);

  // Set the start of the next entry
  $curstart = $curend + 1;

  // Save our current progress
  SaveLastWorkPosition($curstart);
}

echo("All done!");