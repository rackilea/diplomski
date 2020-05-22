statement = (PreparedStatement) con
            .prepareStatement(""
                    + "SELECT FILM,(film_total_ratings/number_of_ratings) as ratings_rating "
                    + "FROM( "
                    + "SELECT COUNT(*) as number_of_ratings, FILM, "
                    + "   SUM(RATING) as film_total_ratings, "
                    + "   SUM(CASE WHEN EMAIL LIKE '%"+email+"%' THEN 1 ELSE 0 END) as rated"
                    + "   FROM  ratings GROUP BY film HAVING rated=0 "
                    + "ORDER BY rating DESC"
                    + ") TMP_Film");