String nextLine;

while (classContinues)
{             
nextLine = inputFile.nextLine();

String[] tokens = nextLine.split(" ");

if(tokens.length == 1) //this means line has '0' character
    classContinues = false;
else
    {
    classContinues = true;

    studentID = tokens[0];
    programGrade = tokens[1];
    midtermGrade = tokens[2];
    finalGrade = tokens[3];

    // your stuff
    }
}