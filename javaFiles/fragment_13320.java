interface Country {
    Country USA = Americas.USA;

    enum Asia implements Country {
        Indian,
        China,
        SriLanka
    }
    enum Americas implements Country {
        USA,
        Brazil
    }
    enum Europe implements Country {
        UK,
        Ireland,
        France
    }
}