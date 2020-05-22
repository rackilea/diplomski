SELECT do.book_ıd,SUM(do.quantity) FROM detaılorder do LEFT JOIN book b on do.book_ıd = b.book_ıd
GROUP BY do.book_ıd
ORDER BY SUM(do.quantity) DESC;

SELECT r.book_ıd,COUNT(r.book_ıd) AS ReviewCount,AVG(r.rating) as AvgRating FROM revıew r LEFT JOIN book b on r.book_ıd = b.book_ıd
GROUP BY r.book_ıd HAVING AVG(r.rating) >= 4.0
ORDER BY ReviewCount DESC, AvgRating DESC;