CREATE TABLE IF NOT EXISTS lyrics (
    id INTEGER PRIMARY KEY,
    song TEXT, 
    year TEXT,
    artist TEXT,
    genre TEXT,
    lyrics TEXT
);
INSERT INTO lyrics (song, year, artist, genre, lyrics) VALUES
    ('song1','1970','Fred','Rock','Rock rock rock'),
    ('song2','1980','Mary','Pop','Pop pop pop'),
    ('song3','1960','Sue','Folk','Folk folk folk');