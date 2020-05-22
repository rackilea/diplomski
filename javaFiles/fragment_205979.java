public class NTPTimeVal extends Structure {
    public TimeVal time;        /* Current time */
    public Long maxerror;       /* Maximum error */
    public Long esterror;
    public int tai;
}