int get_total_without_lowest_roll(int roll_count) {
  int abilityScore = 0;
  int low = MAX_INTEGER;
  int roll;
  for (int i = 0; i < roll_count; i++)
  {
    roll = roll_dice(); // Roll your dice here
    if (roll < low)
    {
        low = roll;     
    } // By the way, good alternative would be low = min(low,roll);
    abilityScore += roll;
  }

  return (abilityScore - low);
}