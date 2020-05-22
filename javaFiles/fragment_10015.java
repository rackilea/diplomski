SELECT LPAD(transaction_id, 5, 0) as transaction_id
, transaction_date
, movie_title
, schedule_price
, mall_name
, schedule_cinema
, schedule_date
, schedule_time 
FROM transaction INNER JOIN schedule ON transaction.schedule_id = schedule.schedule_id
INNER JOIN movie ON schedule.movie_id = movie.movie_id
INNER JOIN mall ON schedule.mall_id = mall.mall_id
WHERE user_id = 'admin';