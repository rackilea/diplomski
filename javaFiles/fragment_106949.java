@ApiModel
public class Input {
    @ApiModelProperty
    public Day day;
}

@ApiModel
public enum Day {
    Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
}