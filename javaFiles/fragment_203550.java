$cacheFileAge = @filemtime($this->cacheFile); //Get Time
foreach(array_merge(array($template),$this->snipFiles) as $f)
  if($cacheFileAge < filemtime($f)) //Compare every template to cache file
    return $this->parse(file_get_contents($template)); //If cache file older than one, re-compile it
debugLog("Using Cached file ({$this->cacheFile})");
include($this->cacheFile); //use cached file