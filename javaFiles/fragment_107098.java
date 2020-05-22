String chosenLanguage = "Language 2";
int languageIndex = -1;
switch(chosenLanguage)
{
    case "Language 1": 
        languageIndex = 0;
        break;
    case "Language 2":
        languageIndex = 1;
        break;
    case "Language 3":
        languageIndex = 2;
        break;
    default:
        languageIndex = 0;
        break;
}

for (Bird birdy : allbirds)
       ListOfAllBirds.add(birdy.names[languageIndex]);