public class PipeFactory(){
    public Pipe CreatePipe( int minGrade, int maxGrade, boolean hasColour0, boolean hasColour1, boolean hasColour2, boolean hasIns, boolean hasReinf ){
       if( (minGrade == 1 || maxGrade == 3) /* ... Complete this condition yourself */ )
           return new TypeIPipe();
       if( (minGrade == 2 || maxGrade == 4 /* ... Complete this condition yourself */ )
           return new TypeIIPipe();
       //If for other types...
       //If no pipe was created, parameters are invalid, so we throw an exception
       throw new InvalidArgumentException( "Can't create a pipe with these parameters" );
    } 
}