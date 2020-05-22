public static Result checkName(String clubname){
     ObjectNode jresult = Json.newObject();

     if (Club.clubExists(clubname)) {
         jresult.put("error", "Club Name Exists");
         return status(409, jresult); // 409 - Conflict
     } else {
         jresult.put("status", "OK");
         return ok(jresult);
     }
}