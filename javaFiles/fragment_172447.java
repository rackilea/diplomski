if (playerDataContainsPlayer(p)){

    PreparedStatement levelUpdate = connection.prepareStatement(
        "UPDATE player_data SET level=level+1 WHERE player=?;"
    );
    levelUpdate.setString(1, p.getName());
    levelUpdate.executeUpdate();
    levelUpdate.close();
    sql.close();

} else {
    ...
}