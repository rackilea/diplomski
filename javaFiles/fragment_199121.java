WITH cte1 AS 
    (
        sum(score) AS sum_score
        FROM myscores
        GROUP BY _id
    )
SELECT max(sum_score) AS min_score, min(sum_score) FROM cte1;