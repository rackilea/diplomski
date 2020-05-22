ArrayList<Achievement> relatedAchievements = new ArrayList<Achievement>();
for (Achievement a : theListOfAchievments) {
     if (a.hasStatistics(targetStatistic)) {
          relatedAchievements.add(a); // at the end this will store the achievements related(that contain) the targetStatistic
     }
}