public void setGrades(float inNumGrade)
{
    this.yourNumberGrade = inNumGrade;
    switch(true)
    {
        case this.yourNumberGrade >= 0.90:
            this.yourLetterGrade = 'A';
            break;
        case this.yourNumberGrade >=0.80:
            this.yourLetterGrade = 'B';
            break;
        case this.yourNumberGrade >=0.70:
            this.yourLetterGrade= 'C';
            break;
        case this.yourNumberGrade >=0.60:
            this.yourLetterGrade= 'D';
            break;
        default:
            this.yourLetterGrade= 'F';    
            break;
    }//end switch
}