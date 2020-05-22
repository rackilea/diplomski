string[] myStrings = { "1",
    "1,2",
    "01,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20",
    "01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19,20",
    "01,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,5",
    "01,02,03,04,05,06,07,08,13,09,10,11,12,13,14,15,16,17,18,19,20" };

Regex reg = new Regex(
    @"^
        (?:(0[1-9]|[1-9]|1[0-9]|20),
            (?!.*\b\1\b) # Fail if the before matched number occurs once more
        )*
        (?:0[1-9]|[1-9]|1[0-9]|20)
    $",
    RegexOptions.IgnorePatternWhitespace
);

foreach (string myString in myStrings)
    Console.WriteLine("{0} {1} a valid string.",
        myString,
        reg.IsMatch(myString) ? "is" : "is not"
    );

Console.ReadLine();