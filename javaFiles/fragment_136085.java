@JsonTypeInfo(  
    use = JsonTypeInfo.Id.NAME,  
    include = JsonTypeInfo.As.PROPERTY,  
    property = "exercise_type",
    visible = true)  
@JsonSubTypes({  
    @Type(value = ExerciseChoiceResponseDTO.class, name = "CHOICE"),  
    @Type(value = ExerciseQuestionResponseDTO.class, name = "QUESTION")})  
public abstract class ExerciseMixIn  
{}