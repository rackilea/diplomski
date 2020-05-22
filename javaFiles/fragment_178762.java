DROP TABLE IF EXISTS DrinksList;
CREATE TABLE IF NOT EXISTS DrinksList (list TEXT UNIQUE NOT NULL);
INSERT INTO DrinksList VALUES
    ('Water, spicy, coke'),             -- Should be found when searching for water
    ('Coke'),                           -- will not be found when seraching for water
    ('Spicy, water, coke'),             -- Should be found
    ('Coke, spicy, water'),             -- Should be found
    ('wateria, spicyer, cokeer'),       -- should not be found
    ('Water, coke, 7up'),               -- should be found
    ('Coke, waterera, 7up'),            -- should not be found
    ('Waterg3d, coke, 7up'),            -- should not be found
    ('Coke, water23, 7up')              -- should not be found
    ;
SELECT * from drinkslist WHERE list||',' LIKE '%'||'water'||',%' OR list||',' LIKE 'water'||',%';