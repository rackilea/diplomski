@Documented
@Target(value={FIELD,METHOD,PARAMETER,LOCAL_VARIABLE})
@Retention(value=CLASS)
@Nonnull(when=ALWAYS)
@TypeQualifierNickname
public @interface NonNull