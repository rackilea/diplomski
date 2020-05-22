Timetracks t = TIMETRACKS;

ctx.insertInto(t)
   .columns(t.ID, t.STARTTIME, t.ENDTIME, t.TASKID)
   .select(
       select(val(someId), val(someStartTime), val(someEndTime), val(someTaskId))
      .whereNotExists(
           selectFrom(t)
          .where( val(someStartTime).between(t.STARTTIME).and(t.ENDTIME)
              .or(val(someEndTime).between(t.STARTTIME).and(t.ENDTIME)) )
          .and(val(someTaskId).eq(t.TASKID))
       )
   )
   .execute();