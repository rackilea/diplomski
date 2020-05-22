public void function OpenFeatureBalloon(GEPlugin plugin, IKMLFeature feature) 
{
  // Get any open balloon
  IGEFeatureBalloon balloon = plugin.getBalloon();

  if (balloon == null) 
  {
     // not there, so create one
     balloon = plugin.createHtmlStringBalloon("");
  }

  // set the balloon to the features geographic location
  balloon.setFeature(feature);

  // open the balloon in the plugin
  ge.setBalloon(balloon);
}