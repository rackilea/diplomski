@Override
public int hashCode() {
    return this.getState().hashCode()
         + this.getActingUser().hashCode()
         + this.getDate().hashCode();
}