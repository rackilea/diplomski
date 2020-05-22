Stack<Integer> reverseLifo = new Stack<Integer>();
int max = Integer.MIN_VALUE;

while (!lifo.isEmpty())
{
    int val = lifo.pop();

    max = Math.max(val, max);

    reverseLifo.push(val);
}

while (!reverseLifo.isEmpty())
{
    lifo.push(reverseLifo.pop());
}

System.out.println("max=" + max.toString());