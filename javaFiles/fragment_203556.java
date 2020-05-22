if( demeaSQL != null){
    StringBuilder sb = new StringBuilder();
    for (User u: demeaSQL.getAllUser()) {
        sb.apppend(u.getUsername + " " + u.getFullname + " " u.getGender);
        sb.append("\n");
    }
    Log.i("Database content", sb.toString());
}