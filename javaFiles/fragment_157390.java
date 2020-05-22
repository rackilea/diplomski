@Override
public int hashCode() {
    int result = (int)symbol;
    result = result*31 + state.hashCode();
    return result;
}