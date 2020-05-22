public void setGrades(float inNumGrade)
{
    this.yourNumberGrade = inNumGrade;

    if( this.yourNumberGrade >= 0.90)
        this.yourLetterGrade = 'A';
    else if(this.yourNumberGrade >=0.80)
        this.yourLetterGrade = 'B';
    else if (this.yourNumberGrade >=0.70)
        this.yourLetterGrade= 'C';
    else if (this.yourNumberGrade >=0.60)
        this.yourLetterGrade= 'D';
    else
        this.yourLetterGrade= 'F';    
}