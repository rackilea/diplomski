/*
 * A Class which is used when getting subTrees Values
 */
class TreeValues
{
    BNode root; //Which node those values apply for
    int Min;
    int Max;
    TreeValues(BNode _node , _min , _max)
    {
        root = _node;
        Min = _min;
        Max = _max;
    }
}