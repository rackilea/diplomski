public static void PushAnswer(int[] m, int value)
{
    if (m[1] >= value) return;
    if (m[0] >= value)
    {
        m[1] = value;
        return;
    }

    m[1] = m[0];
    m[0] = value;
}

public static void largestR(TreeNode<Integer> root, int[] answer)
{
    if (root == null)
    {
        return;
    }

    PushAnswer(answer, root.data);
    for (int i = 0; i < root.children.size(); i++)
    {
        largestR(root.children.get(i));
    }
}

public static int[] getLargestR(TreeNode<Integer> root)
{
    int[] answer = new int[2];
    answer[0] = Integer.MIN_VALUE;
    answer[1] = Integer.MIN_VALUE;
    largestR(root, answer);

    return answer;
}