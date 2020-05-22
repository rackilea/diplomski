public class Bean {
@JsonDeserialize(using = JSONDateAdapter.class)
public DateTime start;

public Bean() {
 // TODO Auto-generated constructor stub
}

public DateTime getStart() {
 return start;
}

public void setStart( DateTime start ) {
 this.start = start;
}
}