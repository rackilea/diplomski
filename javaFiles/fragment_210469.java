@Override
public int noItems() {
    if(rear > front)
        return rear - front;
    return N - front + rear;
}