DELETE
FROM tests
WHERE
    e2e_product_id = 410 AND
    test_name = 'PWBAR-FullBalance-Auth-TC1' AND
    test_id NOT IN (
        SELECT MAX_TEST_ID
        FROM (
            SELECT MAX(test_id) MAX_TEST_ID
            FROM tests
            WHERE e2e_product_id = 410
            GROUP BY test_name
            HAVING COUNT(*) > 1
        ) t
    );