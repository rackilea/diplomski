final long TWO_HOURS_MILIS = 2 * 60 * 60 * 1000l

Date downTimeStartCFDate = (Date)issue.getCustomFieldValue(downTimeStart)
Date downTimeEndCFDate = (Date)issue.getCustomFieldValue(downTimeEnd)
long now = System.currentTimeMillis()
long delta = now - downTimeStartCFDate.time

// fire between 1:59 and 2:00
if( delta % TWO_HOURS_MILIS >= TWO_HOURS_MILLIS - 60000 && now < downTimeEndCFDate.time ){
  sendEmail()
}