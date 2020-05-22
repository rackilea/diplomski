/**
 Set the level of this Category.
 <p>Null values are admitted.
 @deprecated Please use {@link #setLevel} instead.
*/
public void setPriority(Priority priority) {
   this.level = (Level) priority;
}