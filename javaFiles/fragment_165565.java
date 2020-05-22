public boolean jobInList(List<HudsonJob> existingJobs, String wantJob)
{
  for (HudsonJob gotjob : existingJobs)
  {
    if (gotjob.name.toLowerCase().equals(wantJob.toLowerCase())
      return true;
  }
  return false;
}