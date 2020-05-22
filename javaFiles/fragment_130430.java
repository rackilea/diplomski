public void push1(int index) {
    arr[index].size++;
    Stack1.StackNode cur = new Stack1().new StackNode(); // here is my issue
    cur.next = arr[index].top;
    arr[index].top = cur;
}