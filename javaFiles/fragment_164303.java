public interface TeamDAOProtocol {
    void addTeam(ArrayList<TeamModel> entities);
}

public class TeamDAO implements TeamDAOProtocol {
    void addTeam(ArrayList<TeamModel> entities) {
        if (entities == null) return;

        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        for (TeamModel entity : entities)
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("teamname", entity.getTeamname());
                contentValues.put("teamopponent", entity.getTeamopponent());
                contentValues.put("teamdate", entity.getTeamdate());
                db.insert("teamstable", null, contentValues);
                db.setTransactionSuccessful();
            } catch(Exception e) {
            //Error in between database transaction
                e.printStackTrace();
        }
        db.endTransaction();
        db.close();
    }

}