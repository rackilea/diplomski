/**
 Build a list of elements, by visiting root and every descendant of root, and testing it against the evaluator.
 @param eval Evaluator to test elements against
 @param root root of tree to descend
 @return list of matches; empty if none
 */
public static Elements collect (Evaluator eval, Element root) {
    Elements elements = new Elements();
    new NodeTraversor(new Accumulator(root, elements, eval)).traverse(root);
    return elements;
}