....
public static final Skills[] SKILL_TYPE = {Skills.Attack, Skills.Defence, ...};

public String getBigString() { 
    StringBuffer sb = new StringBuffer();
    int nSkills = 0, lSkill = 0;
    for( int i = 0; i < SKILL_TYPE.length; i++ )
      { 
      if( player.getSkills().getXp(SKILL_TYPE[i]) == K_SOMELEVEL ) {
        if(nSkills > 0) sb.append(", ");
        lSkill = sb.length(); // track position of last skill in string
        nSkills += 1;
        sb.append(SKILL_NAME[i]);
        }
      }
    if( nSkills > 0 ) 
      { 
      if( nSkills > 1 ) sb.insert( lSkill, "and ");
      sb.append(".");
      }
    return sb.toString();
}