SELECT Player.team_id AS team_id,
    Player.player_name AS player_name
FROM Player
INNER JOIN Game
    ON (
        (Game.Home_team_id = Player.team_id)
        OR (Game.Guest_team_id = Player.team_id))
WHERE Game.game_id = [YOUR GAME ID];