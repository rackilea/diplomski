Stack<Integer> lifoCopy = (Stack<Integer>) lifo.clone();
int max = Integer.MIN_VALUE;

while (!lifoCopy.isEmpty())
{
    max = Math.max(lifoCopy.pop(), max);
}

System.out.println("max=" + max.toString());